package com.gk.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//@ApiModel: It provides additional information about Swagger Models.
@ApiModel(description = "All Details about the Book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue

	//@ApiModelProperty: It allows controlling swagger-specific definitions such as values, and additional notes.
	@ApiModelProperty(value = "Autogenerated Id")////If we want to give meaning full name to parameters for rest api documentation
	private int bookId;
	
	@ApiModelProperty(value = "This is the book name")
	private String bookName;
	
	@ApiModelProperty(value = "This is Book Price")
	private double bookPrice;
}
