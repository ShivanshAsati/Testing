package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.custom_exceptions.ResourceNotFoundException;
import com.bookstore.dto.AddAuthorDTO;
import com.bookstore.dto.ApiResponse;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.dto.BookDTO;
import com.bookstore.dto.OnlyAuthorDTO;
import com.bookstore.entities.Author;
import com.bookstore.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public ApiResponse addAuthor(AddAuthorDTO authorDTO) {
		Author author = mapper.map(authorDTO, Author.class);
		authorRepository.save(author);
		ApiResponse apiResponse = new ApiResponse("Author Successfully Added!!!");
		return apiResponse;
	}

	@Override
	public List<OnlyAuthorDTO> getAllAuthors() {
		List<OnlyAuthorDTO> authorList = new ArrayList<>();
		authorRepository.findAll().forEach(i -> authorList.add(new OnlyAuthorDTO(i.getId(), i.getName(), i.getBio())));;
		return authorList;
	}


	@Override
	public ApiResponse deleteAuthor(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID!"));
		authorRepository.delete(author);
		return new ApiResponse("Author deleted successfully!");
	}


	@Override
	public AuthorDTO getAuthor(Long id) {
		Author author =  authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author id invalid!"));
		AuthorDTO authorDTO = new AuthorDTO(author.getId(),author.getName(),author.getBio(), new ArrayList<BookDTO>());
		List<BookDTO> bookDTOList = authorDTO.getBookList();
		author.getBook().forEach(i -> bookDTOList.add(new BookDTO(i.getId(),i.getTitle())));
		return authorDTO;
	}

	@Override
	public ApiResponse updateAuthor(OnlyAuthorDTO detachedAuthor) {
		Author author = authorRepository.findById(detachedAuthor.getId()).orElseThrow(() -> new ResourceNotFoundException("Something went wrong!"));
		author.setName(detachedAuthor.getName());
		author.setBio(detachedAuthor.getBio());
		authorRepository.save(author);
		return new ApiResponse("Author updated successfully!");
	}
}
