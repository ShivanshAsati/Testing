package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.custom_exceptions.ResourceNotFoundException;
import com.bookstore.dto.AddAuthorDTO;
import com.bookstore.dto.AddUserDTO;
import com.bookstore.dto.ApiResponse;
import com.bookstore.dto.AuthorBookDTO;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.dto.GetUserDTO;
import com.bookstore.dto.OnlyAuthorDTO;
import com.bookstore.dto.UpdateUserDTO;
import com.bookstore.dto.UserDTO;
import com.bookstore.entities.Author;
import com.bookstore.entities.RoleType;
import com.bookstore.entities.User;
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
		user.setRole(RoleType.USER);
		userRepository.save(user);
		ApiResponse apiResponse = new ApiResponse("USER ADDED SUCCESSFULLY..!!");
		return apiResponse;
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> userList = new ArrayList<>();
		userRepository.findAll().forEach(i -> userList.add(new UserDTO(i.getId(), i.getFirstName(), i.getLastName(), i.getEmail(), i.getMobile(), i.getPassword())));;
		return userList;
	}
	
	@Override
	public ApiResponse deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID!"));
		userRepository.delete(user);
		ApiResponse apiResponse = new ApiResponse("User deleted successfully!");
		return apiResponse;
	}
	
	@Override
	public ApiResponse updateUser(UpdateUserDTO detachedUser) {
		User user = userRepository.findById(detachedUser.getId()).orElseThrow(() -> new ResourceNotFoundException("Something went wrong!"));
		user.setFirstName(detachedUser.getFirstName());
		user.setLastName(detachedUser.getLastName());
		user.setEmail(detachedUser.getEmail());
		user.setMobile(detachedUser.getMobile());
		user.setPassword(detachedUser.getPassword());
		userRepository.save(user);
		return new ApiResponse("User updated successfully!");
	}
	
//	@Override
//	public GetUserDTO getUser(Long id) {
//		User user =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id invalid!"));
//		AddUserDTO userDTO = new AddUserDTO(user.getId(),author.getName(),author.getBio(), new ArrayList<AuthorBookDTO>());
//		List<AuthorBookDTO> bookDTOList = authorDTO.getBookList();
//		author.getBook().forEach(i -> bookDTOList.add(new AuthorBookDTO(i.getId(),i.getTitle())));
//		return authorDTO;
//	}
}











