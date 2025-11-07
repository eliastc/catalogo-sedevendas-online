package com.etc.sedevendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.sedevendas.CategoryDTO;
import com.etc.sedevendas.entities.Category;
import com.etc.sedevendas.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {		
		List<Category> list = repo.findAll();	
		// tambem pode ser feito com funcao de alta ordem, função lambida
		// pegando a lista original percorrendo atraves do map e transformando cada elemento em um novo elemento CategoryDto
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
		/* pode ser feito assim para transformar uma lista(list) 
		// de category em uma lista(listDto) de categoryDto.
		
		//criando uma lista de CategoryDto vazia.
		List<CategoryDTO> listDto = new ArrayList<>();
		
		//criando um for para percorrer a lista de Category e adicionar na lista de 
		// CategoryDto cada dado da lista Category.
		for(Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		
		return listDto;  */
	}
}
