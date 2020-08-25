package com.proj.bookforyou.Library.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.bookforyou.Library.DTO.Bookinfo;
import com.proj.bookforyou.Library.DTO.Collection;
import com.proj.bookforyou.Library.DTO.Indvbookrating;
import com.proj.bookforyou.Library.DTO.Wishbooklist;


public interface LibraryService {
	public List<Indvbookrating> bookRating(String usrnickname);
	public List<Wishbooklist> wishBook(String usrnickname);
	public List<Bookinfo> searchBookinfo(String title);
	public void createCollectionProc(Collection collection);
	public List<Collection> collectionInfo();
}
