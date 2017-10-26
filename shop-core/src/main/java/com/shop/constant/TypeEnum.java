package com.shop.constant;

/**
 * Created by yuanjie on 2017/10/25.
 */
public enum TypeEnum {
    text(0),
    image(1);

    private TypeEnum(){}
    private TypeEnum(Integer type){
        this.type = type;
    }
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static TypeEnum findByType(Integer type){
        for(TypeEnum typeEnum : TypeEnum.values()){
            if(typeEnum.getType()==type ){
                return typeEnum;
            }
        }
        return null;
    }
}
