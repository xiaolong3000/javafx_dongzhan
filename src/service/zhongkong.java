package service;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class zhongkong {

    private  String quanneng;


    public String getQuanneng() {
        return quanneng;
    }

    public void setQuanneng(String quanneng) {
        this.quanneng = quanneng;
    }

    private final SimpleStringProperty checi=new SimpleStringProperty();
    private final SimpleStringProperty kaichetime=new SimpleStringProperty();
    private final SimpleStringProperty xianshitime=new SimpleStringProperty();
    private final SimpleStringProperty zhant=new SimpleStringProperty();
    private final SimpleStringProperty dibiao=new SimpleStringProperty();
    private final SimpleStringProperty shunhao=new SimpleStringProperty();
    private final SimpleStringProperty wandiantime=new SimpleStringProperty();
    private final SimpleStringProperty houche=new SimpleStringProperty();

    public String getHouche() {
        return houche.get();
    }

    public SimpleStringProperty houcheProperty() {
        return houche;
    }

    public void setHouche(String houche) {
        this.houche.set(houche);
    }

    public zhongkong() {
        this("","","","","","","","","");

    }
   public zhongkong(String checi,String kaichetime,String xianshitime,String zhant,String dibiao,String shunhao,String wandiantime,String quanneng,String houche){

        setCheci(checi);
        setKaichetime(kaichetime);
        setXianshitime(xianshitime);
        setZhant(zhant);
        setDibiao(dibiao);
        setShunhao(shunhao);
        setWandiantime(wandiantime);
        setQuanneng(quanneng);
        setHouche(houche);
   }


    public String getCheci() {
        return checi.get();
    }

    public SimpleStringProperty checiProperty() {
        return checi;
    }

    public void setCheci(String checi) {
        this.checi.set(checi);
    }

    public String getKaichetime() {
        return kaichetime.get();
    }

    public SimpleStringProperty kaichetimeProperty() {
        return kaichetime;
    }

    public void setKaichetime(String kaichetime) {
        this.kaichetime.set(kaichetime);
    }

    public String getXianshitime() {
        return xianshitime.get();
    }

    public SimpleStringProperty xianshitimeProperty() {
        return xianshitime;
    }

    public void setXianshitime(String xianshitime) {
        this.xianshitime.set(xianshitime);
    }

    public String getZhant() {
        return zhant.get();
    }

    public SimpleStringProperty zhantProperty() {
        return zhant;
    }

    public void setZhant(String zhant) {
        this.zhant.set(zhant);
    }

    public String getDibiao() {
        return dibiao.get();
    }

    public SimpleStringProperty dibiaoProperty() {
        return dibiao;
    }

    public void setDibiao(String dibiao) {
        this.dibiao.set(dibiao);
    }

    public String getShunhao() {
        return shunhao.get();
    }

    public SimpleStringProperty shunhaoProperty() {
        return shunhao;
    }

    public void setShunhao(String shunhao) {
        this.shunhao.set(shunhao);
    }

    public String getWandiantime() {
        return wandiantime.get();
    }

    public SimpleStringProperty wandiantimeProperty() {
        return wandiantime;
    }

    public void setWandiantime(String wandiantime) {
        this.wandiantime.set(wandiantime);
    }
}
