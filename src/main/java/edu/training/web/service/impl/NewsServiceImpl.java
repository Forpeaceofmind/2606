package edu.training.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.training.web.bean.News;
import edu.training.web.service.NewsService;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> liveNews() {
		List<News> news = new ArrayList<News>();
		news.add(new News("//www.fox29.com/live"));
		return null;
	}

}
