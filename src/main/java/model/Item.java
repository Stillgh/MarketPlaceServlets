package model;


import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
  private int id;
  private String title;
  private String description;
  private int sellerId;
  private float startPrice;
  private float bestOffer;
  private int bidderId;
  private Date startDate;
  private Date endDate;

  public Item(){}

  public Item(int id, String title, String description, int sellerId, float startPrice,
      float bestOffer, int bidderId, Date startDate, Date endDate) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.sellerId = sellerId;
    this.startPrice = startPrice;
    this.bestOffer = bestOffer;
    this.bidderId = bidderId;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getSellerId() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  public float getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(float startPrice) {
    this.startPrice = startPrice;
  }

  public float getBestOffer() {
    return bestOffer;
  }

  public void setBestOffer(float bestOffer) {
    this.bestOffer = bestOffer;
  }

  public int getBidderId() {
    return bidderId;
  }

  public void setBidderId(int bidderId) {
    this.bidderId = bidderId;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", sellerId=" + sellerId +
        ", startPrice=" + startPrice +
        ", bestOffer=" + bestOffer +
        ", bidderId=" + bidderId +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        '}';
  }
}
