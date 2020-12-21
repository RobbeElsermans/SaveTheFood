package com.example.savethefood.Recipe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrients implements Parcelable {

    @SerializedName("ENERC_KCAL")
    @Expose
    private ENERCKCAL eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private FAT fAT;
    @SerializedName("FASAT")
    @Expose
    private FASAT fASAT;
    @SerializedName("FATRN")
    @Expose
    private FATRN fATRN;
    @SerializedName("FAMS")
    @Expose
    private FAMS fAMS;
    @SerializedName("FAPU")
    @Expose
    private FAPU fAPU;
    @SerializedName("CHOCDF")
    @Expose
    private CHOCDF cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private FIBTG fIBTG;
    @SerializedName("SUGAR")
    @Expose
    private SUGAR sUGAR;
    @SerializedName("PROCNT")
    @Expose
    private PROCNT pROCNT;
    @SerializedName("CHOLE")
    @Expose
    private CHOLE cHOLE;
    @SerializedName("NA")
    @Expose
    private NA nA;
    @SerializedName("CA")
    @Expose
    private CA cA;
    @SerializedName("MG")
    @Expose
    private MG mG;
    @SerializedName("K")
    @Expose
    private K k;
    @SerializedName("FE")
    @Expose
    private FE fE;
    @SerializedName("ZN")
    @Expose
    private ZN zN;
    @SerializedName("P")
    @Expose
    private P p;
    @SerializedName("VITA_RAE")
    @Expose
    private VITARAE vITARAE;
    @SerializedName("VITC")
    @Expose
    private VITC vITC;
    @SerializedName("THIA")
    @Expose
    private THIA tHIA;
    @SerializedName("RIBF")
    @Expose
    private RIBF rIBF;
    @SerializedName("NIA")
    @Expose
    private NIA nIA;
    @SerializedName("VITB6A")
    @Expose
    private VITB6A vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    private FOLDFE fOLDFE;
    @SerializedName("FOLFD")
    @Expose
    private FOLFD fOLFD;
    @SerializedName("FOLAC")
    @Expose
    private FOLAC fOLAC;
    @SerializedName("VITB12")
    @Expose
    private VITB12 vITB12;
    @SerializedName("VITD")
    @Expose
    private VITD vITD;
    @SerializedName("TOCPHA")
    @Expose
    private TOCPHA tOCPHA;
    @SerializedName("VITK1")
    @Expose
    private VITK1 vITK1;
    @SerializedName("WATER")
    @Expose
    private WATER wATER;

    protected Nutrients(Parcel in) {
    }

    public static final Creator<Nutrients> CREATOR = new Creator<Nutrients>() {
        @Override
        public Nutrients createFromParcel(Parcel in) {
            return new Nutrients(in);
        }

        @Override
        public Nutrients[] newArray(int size) {
            return new Nutrients[size];
        }
    };

    public ENERCKCAL getENERCKCAL() {
        return eNERCKCAL;
    }

    public FAT getFAT() {
        return fAT;
    }

    public FASAT getFASAT() {
        return fASAT;
    }

    public FATRN getFATRN() {
        return fATRN;
    }

    public FAMS getFAMS() {
        return fAMS;
    }

    public FAPU getFAPU() {
        return fAPU;
    }

    public CHOCDF getCHOCDF() {
        return cHOCDF;
    }

    public FIBTG getFIBTG() {
        return fIBTG;
    }

    public SUGAR getSUGAR() {
        return sUGAR;
    }

    public PROCNT getPROCNT() {
        return pROCNT;
    }

    public CHOLE getCHOLE() {
        return cHOLE;
    }

    public NA getNA() {
        return nA;
    }

    public CA getCA() {
        return cA;
    }

    public MG getMG() {
        return mG;
    }

    public K getK() {
        return k;
    }

    public FE getFE() {
        return fE;
    }

    public ZN getZN() {
        return zN;
    }

    public P getP() {
        return p;
    }

    public VITARAE getVITARAE() {
        return vITARAE;
    }

    public VITC getVITC() {
        return vITC;
    }

    public THIA getTHIA() {
        return tHIA;
    }

    public RIBF getRIBF() {
        return rIBF;
    }

    public NIA getNIA() {
        return nIA;
    }

    public VITB6A getVITB6A() {
        return vITB6A;
    }

    public FOLDFE getFOLDFE() {
        return fOLDFE;
    }

    public FOLFD getFOLFD() {
        return fOLFD;
    }

    public FOLAC getFOLAC() {
        return fOLAC;
    }


    public VITB12 getVITB12() {
        return vITB12;
    }

    public VITD getVITD() {
        return vITD;
    }


    public TOCPHA getTOCPHA() {
        return tOCPHA;
    }

    public VITK1 getVITK1() {
        return vITK1;
    }

    public WATER getWATER() {
        return wATER;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}

 class CA {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }



    public Double getQuantity() {
        return quantity;
    }



    public String getUnit() {
        return unit;
    }



}

 class CHOCDF {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }



    public Double getQuantity() {
        return quantity;
    }



    public String getUnit() {
        return unit;
    }



}

 class CHOLE {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }



    public Double getQuantity() {
        return quantity;
    }



    public String getUnit() {
        return unit;
    }



}

 class ENERCKCAL {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }



    public Double getQuantity() {
        return quantity;
    }



    public String getUnit() {
        return unit;
    }



}

 class FAMS {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }



    public Double getQuantity() {
        return quantity;
    }



    public String getUnit() {
        return unit;
    }



}

 class FAPU {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

class FASAT {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

}

 class FAT {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }


    public Double getQuantity() {
        return quantity;
    }


    public String getUnit() {
        return unit;
    }

}

class FATRN {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }


    public Double getQuantity() {
        return quantity;
    }


    public String getUnit() {
        return unit;
    }
}

 class FE {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

class FIBTG {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

class FOLAC {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

class FOLDFE {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class FOLFD {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class K {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class MG {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class NA {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

 class NIA {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class P {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class PROCNT {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}

 class RIBF {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class SUGAR {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class THIA {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class TOCPHA {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class VITARAE {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class VITB12 {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class VITB6A {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class VITC {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
 class VITD {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
class VITK1 {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
class WATER {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
class ZN {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

