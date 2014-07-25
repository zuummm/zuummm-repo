package org.ave.pet.board;


public class Board {

    private BoardType boardType;
    private BoardGenderType boardGenderType;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private String brand;

    public Board() {
        boardType = BoardType.WAKEBOARD;
        boardGenderType = BoardGenderType.UNISEX;
    }
    
    public Board(BoardType boardType) {
        this.boardType = boardType;
        boardGenderType = BoardGenderType.UNISEX;
    }

    public String getSizeInfo() {
        return length + "x" + width + "x" + height;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public BoardGenderType getBoardGenderType() {
        return boardGenderType;
    }

    public void setBoardGenderType(BoardGenderType boardGenderType) {
        this.boardGenderType = boardGenderType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
