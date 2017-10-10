package service;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class wandian {
    private String kaicheshijian;
    private String xianshishijian;
    private String quannneg;
    private String zhant;
    private String dibiao;
    private String shunhao;

    public String getZhant() {
        return zhant;
    }

    public void setZhant(String zhant) {
        this.zhant = zhant;
    }

    public String getDibiao() {
        return dibiao;
    }

    public void setDibiao(String dibiao) {
        this.dibiao = dibiao;
    }

    public String getShunhao() {
        return shunhao;
    }

    public void setShunhao(String shunhao) {
        this.shunhao = shunhao;
    }

    public String getKaicheshijian() {
        return kaicheshijian;
    }

    public void setKaicheshijian(String kaicheshijian) {
        this.kaicheshijian = kaicheshijian;
    }

    public String getXianshishijian() {
        return xianshishijian;
    }

    public void setXianshishijian(String xianshishijian) {
        this.xianshishijian = xianshishijian;
    }

    public String getQuannneg() {
        return quannneg;
    }

    public void setQuannneg(String quannneg) {
        this.quannneg = quannneg;
    }

    private final SimpleStringProperty wandianshijian=new SimpleStringProperty();
    private final SimpleStringProperty wandianzhant=new SimpleStringProperty();
    private final SimpleStringProperty wandiancheci=new SimpleStringProperty();

    public String getWandianshijian() {
        return wandianshijian.get();
    }

    public SimpleStringProperty wandianshijianProperty() {
        return wandianshijian;
    }

    public void setWandianshijian(String wandianshijian) {
        this.wandianshijian.set(wandianshijian);
    }

    public String getWandianzhant() {
        return wandianzhant.get();
    }

    public SimpleStringProperty wandianzhantProperty() {
        return wandianzhant;
    }

    public void setWandianzhant(String wandianzhant) {
        this.wandianzhant.set(wandianzhant);
    }

    public String getWandiancheci() {
        return wandiancheci.get();
    }

    public SimpleStringProperty wandiancheciProperty() {
        return wandiancheci;
    }

    public void setWandiancheci(String wandiancheci) {
        this.wandiancheci.set(wandiancheci);
    }

    public wandian(String wandiancheci, String wandianzhant, String wandianshijian){
        setWandiancheci(wandiancheci);
        setWandianshijian(wandianshijian);
        setWandianzhant(wandianzhant);
    }
    public wandian(){
        this("","","");
    }
    public wandian(zhongkong zhongkong){
        setWandiancheci(zhongkong.getCheci());
        setWandianshijian(zhongkong.getWandiantime());
        setWandianzhant(zhongkong.getZhant());
        setKaicheshijian(zhongkong.getKaichetime());
        setXianshishijian(zhongkong.getXianshitime());
        setQuannneg(zhongkong.getQuanneng());
        setZhant(zhongkong.getZhant());
        setDibiao(zhongkong.getDibiao());
        setShunhao(zhongkong.getShunhao());
    }
    public wandian(checi checi){
        setWandiancheci(checi.getchechi());
        setWandianshijian(checi.getWandianshijian());
        setWandianzhant(checi.getzhant());
        setKaicheshijian(checi.getKaicheshijian());
        setXianshishijian(checi.getXianshishijian());
        setQuannneg(checi.getQuannneng());
        setZhant(checi.getzhant());
        setDibiao(checi.getdibiao());
        setShunhao(checi.getshunhao());
    }
}
