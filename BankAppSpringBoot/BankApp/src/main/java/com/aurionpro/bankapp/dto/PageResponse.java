package com.aurionpro.bankapp.dto;

import java.util.List;

import com.aurionpro.bankapp.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResponse<T> {
	private long totalElements;
	private int totalPAges;
	private int sze;
	private List<T> contents;
	private boolean isLastPage;
}
