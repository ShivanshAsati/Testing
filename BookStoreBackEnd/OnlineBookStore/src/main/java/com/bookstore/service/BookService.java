package com.bookstore.service;

import com.bookstore.dto.BookDTO;
import com.bookstore.dto.ApiResponse;

public interface BookService {

	ApiResponse addBook(BookDTO bookDTO);

	BookDTO getBookDetails(Long bookId);

}
