package com.sunbeam.controller;

import com.sunbeam.entities.Category;
import com.sunbeam.service.CategoryService;
import com.sunbeam.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    public CategoryController() {
        System.out.println("in ctor "+getClass());
    }
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model modelAttrMap){
        System.out.println("in listCategories "+categoryService.getAllCategories());
        modelAttrMap.addAttribute("categoryList",categoryService.getAllCategories());
        return "/categories/list";
    }
    @GetMapping("/delete")
    public String updateCategory(@RequestParam Long id, RedirectAttributes flashMap){
        System.out.println("in delete Category "+id+ flashMap);
        flashMap.addFlashAttribute("message", categoryService.deleteDetails(id));

        return "redirect:/categories/list";
    }
    @GetMapping("/addform")
    public String showAddRestaurantForm(Model map){
        map.addAttribute("category", new Category());
        return "categories/add_form";
    }
    @PostMapping("/addform")
    public String processAddRestaurantForm(@ModelAttribute("category") Category transientCategory, RedirectAttributes flashMap){
        System.out.println("in processAddRestaurantForm "+transientCategory+ " "+flashMap);
        flashMap.addFlashAttribute("message", categoryService.addCategory(transientCategory));
        return "redirect:/categories/list";
    }
    @GetMapping("/update")
    public String showUpdateRestaurantForm(@RequestParam Long id,Model map){
        System.out.println("in showUpdateRestaurantForm "+id+ " "+map);
        map.addAttribute("category", categoryService.getCategoryById(id));
        return "categories/update_form";
    }
    @PostMapping("/update")
    public String processUpdateRestaurantForm(Long id, @ModelAttribute("category") Category transientCategory, RedirectAttributes flashMap){
        System.out.println("in processUpdateRestaurantForm "+transientCategory+ " "+flashMap);
        flashMap.addFlashAttribute("message", categoryService.updateRestaurant(id, transientCategory));
        return "redirect:/categories/list";
    }
    @GetMapping("/display")
    public String displayCategoryDetails(@RequestParam Long id, Model map){
        map.addAttribute("category", categoryService.displayCategoryDetails(id));
        return "categories/display";
    }

}
