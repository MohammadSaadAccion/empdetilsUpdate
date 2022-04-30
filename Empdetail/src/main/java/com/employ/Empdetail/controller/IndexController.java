package com.employ.Empdetail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController 
{
  @RequestMapping("/")
  public String index()
  {
	  return "index";
  }
  
   @RequestMapping("/insert")
	public String insert()
	{
		return "insert";
	}
   
   @RequestMapping("/display")
	public String display()
	{
		return "display";
	}
   
   @RequestMapping("/update")
	public String update()
	{
		return "update";
	}
   
   @RequestMapping("/delete")
	public String delete()
	{
		return "delete";
	}

}
