package A803.cardian.category.service;

import A803.cardian.category.data.dto.reponse.CategoryList;
import A803.cardian.category.data.dto.reponse.CategoryListImage;
import A803.cardian.category.domain.CategoryIcon;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.CategoryIconRepository;
import A803.cardian.category.repository.SubCommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final SubCommonRepository subCommonRepository;
    @Autowired
    private final CategoryIconRepository categoryIconRepository;

    public List<CategoryList> findAllCategory(){
        List<SubCommonCode> cate= subCommonRepository.findAll();
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

    public List<CategoryListImage> findAllCategoryImage(){
        List<SubCommonCode> cate= subCommonRepository.findAll();

        List<CategoryListImage> cateList= new ArrayList<>();
        for(SubCommonCode sub : cate){
            String categoryCode=sub.getDetailCode();
            String url=categoryIconRepository.findIconImageByCategoryCode(categoryCode).orElse(null);

            CategoryListImage category=CategoryListImage.builder()
                    .categoryCode(sub.getDetailCode())
                    .categoryName(sub.getName())
                    .categoryImage(url)
                    .build();
            cateList.add(category);
        }
        return cateList;
    }


}
