package com.techelevator;

import javax.servlet.http.HttpSession;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	ReviewDao reviewDao;

	@RequestMapping("/")
	public String displayReviews(ModelMap modelMap) {
		List<Review> reviewList = reviewDao.getAllReviews();
		modelMap.put("allReviews", reviewList);
		return "reviews";
	}
}
