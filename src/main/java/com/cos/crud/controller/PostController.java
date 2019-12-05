package com.cos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cos.crud.model.Post;
import com.cos.crud.repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	// http://localhost:8080/post/
	// http://localhost:8080/post
	// Model 은 데이터를 controller 에서 Presentation 계층까지 들고간다
	@GetMapping("")
	public String postList(Model model) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		// webapp/WEB-INF/views/post/list.jsp
		return "post/list";

	}

	// post/4
	@PostMapping("/update")
	public String update(Post post) {// param,form

		try {
			postRepository.update(post);
			return "/post/list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:"; // 함수를 호출항다

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {// param,form

		try {
			postRepository.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/post"; // 함수를 호출항다

	}

	@PostMapping("/save")
	public String save(Post post) {
		try {
			postRepository.save(post);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "redirect:/post";
	}
	
	@GetMapping("/writeForm")
	public String WriteForm() {
	return"post/writeForm";
	}

	// http://localhost
	@GetMapping("/{id}")
	public String post(@PathVariable int id, Model model) {
		Post post = postRepository.findById(id);
		model.addAttribute("post", post);
		return "post/detail";

	}
	
	//http://localhost:8080/post/u
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Post post=postRepository.findById(id);
		model.addAttribute("post",post);
		
		return "post/updateForm";
	}
}