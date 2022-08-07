package com.challenge.backend.shared.mapping;


import com.challenge.backend.category.mapping.CategoryMapper;
import com.challenge.backend.note.mapping.NoteMapper;
import com.challenge.backend.users.mapping.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("challengeModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }

    @Bean
    public UserMapper  userMapper() { return new UserMapper();}

    @Bean
    public NoteMapper noteMapper(){ return new NoteMapper();}

    @Bean
    public CategoryMapper categoryMapper () { return  new CategoryMapper();}
}
