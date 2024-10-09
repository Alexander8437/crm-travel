package com.ms.jwt.models.pkg;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "media")
public class Medium {
    @Id
  
    private String id;

    @ElementCollection
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "medium_id"))
    private List<Image> images;

    @ElementCollection
    @CollectionTable(name = "videos", joinColumns = @JoinColumn(name = "medium_id"))
    private List<Video> videos;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    @JsonBackReference
    private PackageInfo packageInfo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public PackageInfo getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(PackageInfo packageInfo) {
		this.packageInfo = packageInfo;
	}

     
}
