package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dto.BookDTO;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.addBook(bookDTO));
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> getBookDetails(@PathVariable Long bookId){
		System.out.println("In getBookDetails() : " + bookId);
		return ResponseEntity.ok(bookService.getBookDetails(bookId));
		
	}
	
}
