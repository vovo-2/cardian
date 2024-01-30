package A803.cardian.category.service;

import A803.cardian.category.data.dto.reponse.CategoryList;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;


    public List<CategoryList> findAllCategory(){
        List<SubCommonCode> cate= categoryRepository.findAll();
        List<CategoryList> cateList= new ArrayList<>();
        for(SubCommonCode sub : cate){
            CategoryList category=CategoryList.builder()
                    .categoryCode(sub.getDetailCode())
                    .categoryName(sub.getName())
                    .build();
            cateList.add(category);
        }
        return cateList;
    }


}
