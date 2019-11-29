package com.raulfm.drinkit.model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drink {
    @SerializedName("idDrink")
    @Expose
    private String idDrink;

    @SerializedName("strDrink")
    @Expose
    private String strDrink;

    @SerializedName("strDrinkAlternate")
    @Expose
    private String strDrinkAlternate;

    @SerializedName("strDrinkES")
    @Expose
    private String strDrinkES;

    @SerializedName("strDrinkDE")
    @Expose
    private String strDrinkDE;

    @SerializedName("strDrinkFR")
    @Expose
    private String strDrinkFR;

    @SerializedName("strDrinkZH-HANS")
    @Expose
    private String strDrinkZHHANS;

    @SerializedName("strDrinkZH-HANT")
    @Expose
    private String strDrinkZHHANT;

    @SerializedName("strTags")
    @Expose
    private String strTags;

    @SerializedName("strVideo")
    @Expose
    private String strVideo;

    @SerializedName("strCategory")
    @Expose
    private String strCategory;

    @SerializedName("strIBA")
    @Expose
    private String strIBA;

    @SerializedName("strAlcoholic")
    @Expose
    private String strAlcoholic;

    @SerializedName("strGlass")
    @Expose
    private String strGlass;

    @SerializedName("strInstructions")
    @Expose
    private String strInstructions;

    @SerializedName("strInstructionsES")
    @Expose
    private String strInstructionsES;

    @SerializedName("strInstructionsDE")
    @Expose
    private String strInstructionsDE;

    @SerializedName("strInstructionsFR")
    @Expose
    private String strInstructionsFR;

    @SerializedName("strInstructionsZH-HANS")
    @Expose
    private String strInstructionsZHHANS;

    @SerializedName("strInstructionsZH-HANT")
    @Expose
    private String strInstructionsZHHANT;

    @SerializedName("strDrinkThumb")
    @Expose
    private String strDrinkThumb;

    @SerializedName("strIngredient1")
    @Expose
    private String strIngredient1;

    @SerializedName("strIngredient2")
    @Expose
    private String strIngredient2;

    @SerializedName("strIngredient3")
    @Expose
    private String strIngredient3;

    @SerializedName("strIngredient4")
    @Expose
    private String strIngredient4;

    @SerializedName("strIngredient5")
    @Expose
    private String strIngredient5;

    @SerializedName("strIngredient6")
    @Expose
    private String strIngredient6;

    @SerializedName("strIngredient7")
    @Expose
    private String strIngredient7;

    @SerializedName("strIngredient8")
    @Expose
    private String strIngredient8;

    @SerializedName("strIngredient9")
    @Expose
    private String strIngredient9;

    @SerializedName("strIngredient10")
    @Expose
    private String strIngredient10;

    @SerializedName("strIngredient11")
    @Expose
    private String strIngredient11;

    @SerializedName("strIngredient12")
    @Expose
    private String strIngredient12;

    @SerializedName("strIngredient13")
    @Expose
    private String strIngredient13;

    @SerializedName("strIngredient14")
    @Expose
    private String strIngredient14;

    @SerializedName("strIngredient15")
    @Expose
    private String strIngredient15;

    @SerializedName("strMeasure1")
    @Expose
    private String strMeasure1;

    @SerializedName("strMeasure2")
    @Expose
    private String strMeasure2;

    @SerializedName("strMeasure3")
    @Expose
    private String strMeasure3;

    @SerializedName("strMeasure4")
    @Expose
    private String strMeasure4;

    @SerializedName("strMeasure5")
    @Expose
    private String strMeasure5;

    @SerializedName("strMeasure6")
    @Expose
    private String strMeasure6;

    @SerializedName("strMeasure7")
    @Expose
    private String strMeasure7;

    @SerializedName("strMeasure8")
    @Expose
    private String strMeasure8;

    @SerializedName("strMeasure9")
    @Expose
    private String strMeasure9;

    @SerializedName("strMeasure10")
    @Expose
    private String strMeasure10;

    @SerializedName("strMeasure11")
    @Expose
    private String strMeasure11;

    @SerializedName("strMeasure12")
    @Expose
    private String strMeasure12;

    @SerializedName("strMeasure13")
    @Expose
    private String strMeasure13;

    @SerializedName("strMeasure14")
    @Expose
    private String strMeasure14;

    @SerializedName("strMeasure15")
    @Expose
    private String strMeasure15;

    @SerializedName("strCreativeCommonsConfirmed")
    @Expose
    private String strCreativeCommonsConfirmed;

    @SerializedName("dateModified")
    @Expose
    private String dateModified;

    private Drink() {
    }

    public Drink(String idDrink, String strDrink){
        this.idDrink = idDrink;
        this.strDrink = strDrink;
    }

    private Drink(String idDrink, String strDrink, String strDrinkAlternate, String strDrinkES, String strDrinkDE, String strDrinkFR, String strDrinkZHHANS, String strDrinkZHHANT, String strTags, String strVideo, String strCategory, String strIBA, String strAlcoholic, String strGlass, String strInstructions, String strInstructionsES, String strInstructionsDE, String strInstructionsFR, String strInstructionsZHHANS, String strInstructionsZHHANT, String strDrinkThumb, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strCreativeCommonsConfirmed, String dateModified) {
        super();
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strDrinkES = strDrinkES;
        this.strDrinkDE = strDrinkDE;
        this.strDrinkFR = strDrinkFR;
        this.strDrinkZHHANS = strDrinkZHHANS;
        this.strDrinkZHHANT = strDrinkZHHANT;
        this.strTags = strTags;
        this.strVideo = strVideo;
        this.strCategory = strCategory;
        this.strIBA = strIBA;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strInstructions = strInstructions;
        this.strInstructionsES = strInstructionsES;
        this.strInstructionsDE = strInstructionsDE;
        this.strInstructionsFR = strInstructionsFR;
        this.strInstructionsZHHANS = strInstructionsZHHANS;
        this.strInstructionsZHHANT = strInstructionsZHHANT;
        this.strDrinkThumb = strDrinkThumb;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        this.dateModified = dateModified;
    }

    public String getidDrink() {
        return idDrink;
    }

    public void setidDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getstrDrink() {
        return strDrink.toUpperCase();
    }

    public void setstrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getstrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setstrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getstrDrinkES() {
        return strDrinkES;
    }

    public void setstrDrinkES(String strDrinkES) {
        this.strDrinkES = strDrinkES;
    }

    public String getstrDrinkDE() {
        return strDrinkDE;
    }

    public void setstrDrinkDE(String strDrinkDE) {
        this.strDrinkDE = strDrinkDE;
    }

    public String getstrDrinkFR() {
        return strDrinkFR;
    }

    public void setstrDrinkFR(String strDrinkFR) {
        this.strDrinkFR = strDrinkFR;
    }

    public String getstrDrinkZHHANS() {
        return strDrinkZHHANS;
    }

    public void setstrDrinkZHHANS(String strDrinkZHHANS) {
        this.strDrinkZHHANS = strDrinkZHHANS;
    }

    public String getstrDrinkZHHANT() {
        return strDrinkZHHANT;
    }

    public void setstrDrinkZHHANT(String strDrinkZHHANT) {
        this.strDrinkZHHANT = strDrinkZHHANT;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public void setStrVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getstrCategory() {
        return strCategory;
    }

    public void setstrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrIBA() {
        return strIBA;
    }

    public void setStrIBA(String strIBA) {
        this.strIBA = strIBA;
    }

    public String getstrAlcoholic() {
        return strAlcoholic;
    }

    public void setstrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getstrGlass() {
        return strGlass;
    }

    public void setstrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getstrInstructions() {
        return strInstructions;
    }

    public void setstrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getstrInstructionsES() {
        return strInstructionsES;
    }

    public void setstrInstructionsES(String strInstructionsES) {
        this.strInstructionsES = strInstructionsES;
    }

    public String getstrInstructionsDE() {
        return strInstructionsDE;
    }

    public void setstrInstructionsDE(String strInstructionsDE) {
        this.strInstructionsDE = strInstructionsDE;
    }

    public String getstrInstructionsFR() {
        return strInstructionsFR;
    }

    public void setstrInstructionsFR(String strInstructionsFR) {
        this.strInstructionsFR = strInstructionsFR;
    }

    public String getstrInstructionsZHHANS() {
        return strInstructionsZHHANS;
    }

    public void setstrInstructionsZHHANS(String strInstructionsZHHANS) {
        this.strInstructionsZHHANS = strInstructionsZHHANS;
    }

    public String getstrInstructionsZHHANT() {
        return strInstructionsZHHANT;
    }

    public void setstrInstructionsZHHANT(String strInstructionsZHHANT) {
        this.strInstructionsZHHANT = strInstructionsZHHANT;
    }

    public String getstrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setstrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getstrIngredient1() {
        return strIngredient1;
    }

    public void setstrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getstrIngredient2() {
        return strIngredient2;
    }

    public void setstrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getstrIngredient3() {
        return strIngredient3;
    }

    public void setstrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getstrIngredient4() {
        return strIngredient4;
    }

    public void setstrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getstrIngredient5() {
        return strIngredient5;
    }

    public void setstrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getstrIngredient6() {
        return strIngredient6;
    }

    public void setstrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getstrIngredient7() {
        return strIngredient7;
    }

    public void setstrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getstrIngredient8() {
        return strIngredient8;
    }

    public void setstrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getstrIngredient9() {
        return strIngredient9;
    }

    public void setstrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getstrIngredient10() {
        return strIngredient10;
    }

    public void setstrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getstrIngredient11() {
        return strIngredient11;
    }

    public void setstrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getstrIngredient12() {
        return strIngredient12;
    }

    public void setstrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getstrIngredient13() {
        return strIngredient13;
    }

    public void setstrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getstrIngredient14() {
        return strIngredient14;
    }

    public void setstrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getstrIngredient15() {
        return strIngredient15;
    }

    public void setstrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public List<String> getAllIngredients() {
        ArrayList<String> ingredients = new ArrayList<>();
        for(int i=1;i<=15;i++){
            try {
                String ing = (String) Drink.class.getDeclaredField("strIngredient" + i).get(this);
                if(ing!=null && ing.length()>0)
                    ingredients .add(ing);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                Log.d("error", Objects.requireNonNull(e.getMessage()));
            }
        }
        return ingredients;
    }

    public String getstrMeasure1() {
        return strMeasure1;
    }

    public void setstrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getstrMeasure2() {
        return strMeasure2;
    }

    public void setstrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getstrMeasure3() {
        return strMeasure3;
    }

    public void setstrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getstrMeasure4() {
        return strMeasure4;
    }

    public void setstrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getstrMeasure5() {
        return strMeasure5;
    }

    public void setstrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getstrMeasure6() {
        return strMeasure6;
    }

    public void setstrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getstrMeasure7() {
        return strMeasure7;
    }

    public void setstrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getstrMeasure8() {
        return strMeasure8;
    }

    public void setstrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getstrMeasure9() {
        return strMeasure9;
    }

    public void setstrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getstrMeasure10() {
        return strMeasure10;
    }

    public void setstrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getstrMeasure11() {
        return strMeasure11;
    }

    public void setstrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getstrMeasure12() {
        return strMeasure12;
    }

    public void setstrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getstrMeasure13() {
        return strMeasure13;
    }

    public void setstrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getstrMeasure14() {
        return strMeasure14;
    }

    public void setstrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getstrMeasure15() {
        return strMeasure15;
    }

    public void setstrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(idDrink, drink.idDrink) &&
                Objects.equals(strDrink, drink.strDrink) &&
                Objects.equals(strDrinkAlternate, drink.strDrinkAlternate) &&
                Objects.equals(strDrinkES, drink.strDrinkES) &&
                Objects.equals(strDrinkDE, drink.strDrinkDE) &&
                Objects.equals(strDrinkFR, drink.strDrinkFR) &&
                Objects.equals(strDrinkZHHANS, drink.strDrinkZHHANS) &&
                Objects.equals(strDrinkZHHANT, drink.strDrinkZHHANT) &&
                Objects.equals(strTags, drink.strTags) &&
                Objects.equals(strVideo, drink.strVideo) &&
                Objects.equals(strCategory, drink.strCategory) &&
                Objects.equals(strIBA, drink.strIBA) &&
                Objects.equals(strAlcoholic, drink.strAlcoholic) &&
                Objects.equals(strGlass, drink.strGlass) &&
                Objects.equals(strInstructions, drink.strInstructions) &&
                Objects.equals(strInstructionsES, drink.strInstructionsES) &&
                Objects.equals(strInstructionsDE, drink.strInstructionsDE) &&
                Objects.equals(strInstructionsFR, drink.strInstructionsFR) &&
                Objects.equals(strInstructionsZHHANS, drink.strInstructionsZHHANS) &&
                Objects.equals(strInstructionsZHHANT, drink.strInstructionsZHHANT) &&
                Objects.equals(strDrinkThumb, drink.strDrinkThumb) &&
                Objects.equals(strIngredient1, drink.strIngredient1) &&
                Objects.equals(strIngredient2, drink.strIngredient2) &&
                Objects.equals(strIngredient3, drink.strIngredient3) &&
                Objects.equals(strIngredient4, drink.strIngredient4) &&
                Objects.equals(strIngredient5, drink.strIngredient5) &&
                Objects.equals(strIngredient6, drink.strIngredient6) &&
                Objects.equals(strIngredient7, drink.strIngredient7) &&
                Objects.equals(strIngredient8, drink.strIngredient8) &&
                Objects.equals(strIngredient9, drink.strIngredient9) &&
                Objects.equals(strIngredient10, drink.strIngredient10) &&
                Objects.equals(strIngredient11, drink.strIngredient11) &&
                Objects.equals(strIngredient12, drink.strIngredient12) &&
                Objects.equals(strIngredient13, drink.strIngredient13) &&
                Objects.equals(strIngredient14, drink.strIngredient14) &&
                Objects.equals(strIngredient15, drink.strIngredient15) &&
                Objects.equals(strMeasure1, drink.strMeasure1) &&
                Objects.equals(strMeasure2, drink.strMeasure2) &&
                Objects.equals(strMeasure3, drink.strMeasure3) &&
                Objects.equals(strMeasure4, drink.strMeasure4) &&
                Objects.equals(strMeasure5, drink.strMeasure5) &&
                Objects.equals(strMeasure6, drink.strMeasure6) &&
                Objects.equals(strMeasure7, drink.strMeasure7) &&
                Objects.equals(strMeasure8, drink.strMeasure8) &&
                Objects.equals(strMeasure9, drink.strMeasure9) &&
                Objects.equals(strMeasure10, drink.strMeasure10) &&
                Objects.equals(strMeasure11, drink.strMeasure11) &&
                Objects.equals(strMeasure12, drink.strMeasure12) &&
                Objects.equals(strMeasure13, drink.strMeasure13) &&
                Objects.equals(strMeasure14, drink.strMeasure14) &&
                Objects.equals(strMeasure15, drink.strMeasure15) &&
                Objects.equals(strCreativeCommonsConfirmed, drink.strCreativeCommonsConfirmed) &&
                Objects.equals(dateModified, drink.dateModified);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idDrink, strDrink, strDrinkAlternate, strDrinkES, strDrinkDE, strDrinkFR, strDrinkZHHANS, strDrinkZHHANT, strTags, strVideo, strCategory, strIBA, strAlcoholic, strGlass, strInstructions, strInstructionsES, strInstructionsDE, strInstructionsFR, strInstructionsZHHANS, strInstructionsZHHANT, strDrinkThumb, strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15, strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15, strCreativeCommonsConfirmed, dateModified);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", strDrinkAlternate=" + strDrinkAlternate +
                ", strDrinkES=" + strDrinkES +
                ", strDrinkDE=" + strDrinkDE +
                ", strDrinkFR=" + strDrinkFR +
                ", strDrinkZHHANS=" + strDrinkZHHANS +
                ", strDrinkZHHANT=" + strDrinkZHHANT +
                ", strTags='" + strTags + '\'' +
                ", strVideo=" + strVideo +
                ", strCategory='" + strCategory + '\'' +
                ", strIBA='" + strIBA + '\'' +
                ", strAlcoholic='" + strAlcoholic + '\'' +
                ", strGlass='" + strGlass + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strInstructionsES=" + strInstructionsES +
                ", strInstructionsDE='" + strInstructionsDE + '\'' +
                ", strInstructionsFR=" + strInstructionsFR +
                ", strInstructionsZHHANS=" + strInstructionsZHHANS +
                ", strInstructionsZHHANT=" + strInstructionsZHHANT +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", strIngredient1='" + strIngredient1 + '\'' +
                ", strIngredient2='" + strIngredient2 + '\'' +
                ", strIngredient3='" + strIngredient3 + '\'' +
                ", strIngredient4='" + strIngredient4 + '\'' +
                ", strIngredient5=" + strIngredient5 +
                ", strIngredient6=" + strIngredient6 +
                ", strIngredient7=" + strIngredient7 +
                ", strIngredient8=" + strIngredient8 +
                ", strIngredient9=" + strIngredient9 +
                ", strIngredient10=" + strIngredient10 +
                ", strIngredient11=" + strIngredient11 +
                ", strIngredient12=" + strIngredient12 +
                ", strIngredient13=" + strIngredient13 +
                ", strIngredient14=" + strIngredient14 +
                ", strIngredient15=" + strIngredient15 +
                ", strMeasure1='" + strMeasure1 + '\'' +
                ", strMeasure2='" + strMeasure2 + '\'' +
                ", strMeasure3='" + strMeasure3 + '\'' +
                ", strMeasure4=" + strMeasure4 +
                ", strMeasure5=" + strMeasure5 +
                ", strMeasure6=" + strMeasure6 +
                ", strMeasure7=" + strMeasure7 +
                ", strMeasure8=" + strMeasure8 +
                ", strMeasure9=" + strMeasure9 +
                ", strMeasure10=" + strMeasure10 +
                ", strMeasure11=" + strMeasure11 +
                ", strMeasure12=" + strMeasure12 +
                ", strMeasure13=" + strMeasure13 +
                ", strMeasure14=" + strMeasure14 +
                ", strMeasure15=" + strMeasure15 +
                ", strCreativeCommonsConfirmed='" + strCreativeCommonsConfirmed + '\'' +
                ", dateModified='" + dateModified + '\'' +
                '}';
    }
}
