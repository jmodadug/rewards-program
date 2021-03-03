package com.rewardsprogram.request.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerId", "customerName", "totalTransactionAmount", "totalRewardPoints" })
public class RewardResponse {

	@JsonProperty("customerId")
	public Long customerId;
	@JsonProperty("customerName")
	public String customerName;
	@JsonProperty("totalTransactionAmount")
	public Long totalTransactionAmount;
	@JsonProperty("totalRewardPoints")
	public Long totalRewardPoints;

}
