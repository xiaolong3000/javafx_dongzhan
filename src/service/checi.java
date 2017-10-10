package service;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class checi {
    private String kaicheshijian;
    private String xianshishijian;
    private final SimpleStringProperty wandianshijian=new SimpleStringProperty();
    private String quannneng;

    public SimpleStringProperty wandianshijianProperty() {
        return wandianshijian;
    }

    public String getWandianshijian() {
        return wandianshijian.get();
    }

    public void setWandianshijian(String wandianshijian) {
        this.wandianshijian.set(wandianshijian);
    }

    public String getQuannneng() {
        return quannneng;
    }

    public void setQuannneng(String quannneng) {
        this.quannneng = quannneng;
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



    private final SimpleStringProperty checi = new SimpleStringProperty();
    private final SimpleStringProperty zhant = new SimpleStringProperty();
    private final SimpleStringProperty dibiao = new SimpleStringProperty();
    private final SimpleStringProperty shunhao = new SimpleStringProperty();

    public SimpleStringProperty checiProperty(){
        return checi;
    }
    public SimpleStringProperty zhantProperty(){
        return zhant;
    }
    public SimpleStringProperty dibiaoProperty(){
        return dibiao;
    }
    public SimpleStringProperty shunhaoProperty(){
        return shunhao;
    }

   public checi(String checi,String zhant,String dibiao,String shunhao,String kaicheshijian,String xianshishijian,String wandianshijian,String quannneng){
        setCheci(checi);
        setDibiao(dibiao);
        setZhant(zhant);
        setShunhao(shunhao);
       setKaicheshijian(kaicheshijian);
       setXianshishijian(xianshishijian);
       setWandianshijian(wandianshijian);
       setQuannneng(quannneng);

   }
   public checi(){
       this("","","","","","","","");
   }
   public  checi(zhongkong zhongkong){
       setCheci(zhongkong.getCheci());
       setDibiao(zhongkong.getDibiao());
       setZhant(zhongkong.getZhant());
       setShunhao(zhongkong.getShunhao());
       setKaicheshijian(zhongkong.getKaichetime());
       setXianshishijian(zhongkong.getXianshitime());
       setWandianshijian(zhongkong.getWandiantime());
       setQuannneng(zhongkong.getQuanneng());
   }
   public checi(wandian wandian){
       setCheci(wandian.getWandiancheci());
       setKaicheshijian(wandian.getKaicheshijian());
       setXianshishijian(wandian.getXianshishijian());
       setZhant(wandian.getZhant());
       setDibiao(wandian.getDibiao());
       setShunhao(wandian.getShunhao());
       setWandianshijian(wandian.getWandianshijian());
       setQuannneng(wandian.getQuannneg());
   }

    public String getchechi(){
        return checi.get();
    }
    public String getzhant(){
        return zhant.get();
    }
    public String getdibiao(){
        return dibiao.get();
    }
    public String getshunhao(){
        return shunhao.get();
    }


    public void setCheci(String checi){
        this.checi.set(checi);
    }
    public void setZhant(String zhant){
        this.zhant.set(zhant);
    }
    public void setDibiao(String dibiao){
        this.dibiao.set(dibiao);
    }
    public void setShunhao(String shunhao){
        this.shunhao.set(shunhao);
    }


    public String toString(){
        return dibiao.get();
    }
}
