package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dto.AddAuthorDTO;
import com.bookstore.dto.AddUserDTO;
import com.bookstore.dto.ApiResponse;
import com.bookstore.dto.OnlyAuthorDTO;
import com.bookstore.entities.Author;
import com.bookstore.entities.User;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse addUser(AddUserDTO userDTO) 
	{
		User user = mapper.map(userDTO, User.class);
		userRepository.save(user);
		ApiResponse apiResponse = new ApiResponse("USER ADDED SUCCESSFULLY..!!");
		return apiResponse;
	}
	
	@Override
	public List<AddUserDTO> getAllUsers() {
		List<AddUserDTO> userList = new ArrayList<>();
		userRepository.findAll().forEach(i -> userList.add(new AddUserDTO(i.getFirstName(), i.getLastName(), i.getEmail(), i.getMobile(), i.getPassword())));;
		return userList;
	}
}











