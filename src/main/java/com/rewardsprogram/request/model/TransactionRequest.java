package com.rewardsprogram.request.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerId","productName", "productCost" })
public class TransactionRequest {

	@JsonProperty("customerId")
	private Long customerId;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("productCost")
	private Long productCost;

}
