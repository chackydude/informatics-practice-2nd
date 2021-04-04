package ru.itis.trofimoff.lazy.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.itis.trofimoff.lazy.models.Category;
import ru.itis.trofimoff.lazy.services.CategoryService;

@Component
public class CategoryConverter implements Converter<Integer, Category> {

    @Autowired
    public CategoryService categoryService;

    @Override
    public Category convert(Integer id) {
        return categoryService.findById(id);
    }
}
