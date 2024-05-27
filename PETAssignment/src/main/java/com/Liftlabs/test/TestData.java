package com.Liftlabs.test;



import java.util.Arrays;
import java.util.List;

public class TestData {
    
    public static Root createPet(Long id, String name, String status, String tagName) {
        Category category = new Category();
        category.setId(1);
        category.setName("string");

        Tags tag = new Tags();
        tag.setId(1);
        tag.setName(tagName);

        Root pet = new Root();
        pet.setId(id);
        pet.setCategory(category);
        pet.setName(name);
        pet.setPhotoUrls(Arrays.asList("string"));
        pet.setTags(Arrays.asList(tag));
        pet.setStatus(status);
        
        return pet;
    }
}
