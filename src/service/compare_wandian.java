package service;

import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class compare_wandian {
    public boolean compare_checi(List<checi> list, ObservableList<checi> olist){
        boolean flag=true;
        if (list.size()!=olist.size()){
            flag=false;
            return flag;
        }
        if (list.size()==0&&olist.size()==0){
                  flag=true;
                  return flag;
        }
        for (int i=0;i<list.size();i++){
            if (!list.get(i).getchechi().equals(olist.get(i).getchechi())){
                flag=false;
                return flag;
            }
        }

        return flag;

    }
    public boolean compare_zhongkong(List<zhongkong> list, ObservableList<zhongkong> olist){
        boolean flag=true;
        if (list.size()!=olist.size()){
            flag=false;
            return flag;
        }
        if (list.size()==0&&olist.size()==0){
            flag=true;
            return flag;
        }
        for (int i=0;i<list.size();i++){
            if (!list.get(i).getCheci().equals(olist.get(i).getCheci())){
                flag=false;
                return flag;
            }
        }

        return flag;

    }
    public boolean compare_wandian(List<wandian> list, ObservableList<wandian> olist){
        boolean flag=true;
        if (list.size()!=olist.size()){
            flag=false;
            return flag;
        }
        if (list.size()==0&&olist.size()==0){
            flag=true;
            return flag;
        }
        for (int i=0;i<list.size();i++){
            if (!list.get(i).getWandiancheci().equals(olist.get(i).getWandiancheci())){
                flag=false;
                return flag;
            }
        }

        return flag;

    }
}
