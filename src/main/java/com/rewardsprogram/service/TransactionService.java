package com.rewardsprogram.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewardsprogram.exception.RewardsProgramException;
import com.rewardsprogram.model.Customer;
import com.rewardsprogram.model.TransactionEntity;
import com.rewardsprogram.repository.TransactionRepository;
import com.rewardsprogram.repository.CustomerRepository;
import com.rewardsprogram.request.model.RewardResponse;
import com.rewardsprogram.request.model.TransactionRequest;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<TransactionEntity> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public TransactionEntity createTransaction(@Valid TransactionRequest transactionRequest) {
		Customer customer=customerRepository.findById(transactionRequest.getCustomerId())
				.orElseThrow(() -> new RewardsProgramException("Customer", "id", transactionRequest.getCustomerId()));
		TransactionEntity transaction = new TransactionEntity();
		transaction.setProductName(transactionRequest.getProductName());
		transaction.setProductCost(transactionRequest.getProductCost());
		transaction.setTransactionDate(new Date());
		transaction.setCreatedTimestamp(new Date());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getProductCost()));
		transaction.setCustomer(customer);
		return transactionRepository.save(transaction);
	}

	private Long calculateRewardPoints(Long itemCost) {
		Long rewardPoints = 0L;
		if (itemCost > 100) {
			rewardPoints = ((100 - 50) * 1) + ((itemCost - 100) * 2);
		} else if (itemCost > 50 && itemCost < 100) {
			rewardPoints = (itemCost - 50) * 1;
		}
		return rewardPoints;
	}

	public Optional<TransactionEntity> getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}

	public void deleteTransaction(Long transactionId) {
		TransactionEntity transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new RewardsProgramException("Transaction", "id", transactionId));
		transactionRepository.delete(transaction);

	}

	public TransactionEntity updateTransaction(Long transactionId, @Valid TransactionRequest transactionRequest) {
		Customer customer=customerRepository.findById(transactionRequest.getCustomerId())
				.orElseThrow(() -> new RewardsProgramException("Customer", "id", transactionRequest.getCustomerId()));
		TransactionEntity transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new RewardsProgramException("Transaction", "id", transactionId));
		transaction.setProductName(transactionRequest.getProductName());
		transaction.setProductCost(transactionRequest.getProductCost());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setTransactionDate(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getProductCost()));
		transaction.setCustomer(customer);
		return transactionRepository.save(transaction);
	}

	public List<TransactionEntity> getRewardsInrange(Long customerId, String fromDate, String toDate) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<TransactionEntity> trans=transactionRepository.getRewardsInrange(customerId,format.parse(fromDate),format.parse(toDate));
		return trans;
	}

	public RewardResponse getTotalRewardsInrange(Long customerId, String fromDate, String toDate) throws ParseException {
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(() -> new RewardsProgramException("Customer", "id", customerId));
		List<TransactionEntity> trans=getRewardsInrange(customerId,fromDate,toDate);
		
		RewardResponse rewardResponse=new RewardResponse();
		rewardResponse.setTotalTransactionAmount(trans.stream().mapToLong(transaction-> transaction.getProductCost()).sum());
		rewardResponse.setTotalRewardPoints(trans.stream().mapToLong(transaction-> transaction.getRewardPoints()).sum());
		rewardResponse.setCustomerId(customerId);
		rewardResponse.setCustomerName(customer.getCustomerName());
		return rewardResponse;
	}

}
