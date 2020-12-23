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
        dest.writeParcelable(this.eNERCKCAL, flags);
        dest.writeParcelable(this.fAT, flags);
        dest.writeParcelable(this.fASAT, flags);
        dest.writeParcelable(this.fATRN, flags);
        dest.writeParcelable(this.fAMS, flags);
        dest.writeParcelable(this.fAPU, flags);
        dest.writeParcelable(this.cHOCDF, flags);
        dest.writeParcelable(this.fIBTG, flags);
        dest.writeParcelable(this.sUGAR, flags);
        dest.writeParcelable(this.pROCNT, flags);
        dest.writeParcelable(this.cHOLE, flags);
        dest.writeParcelable(this.nA, flags);
        dest.writeParcelable(this.cA, flags);
        dest.writeParcelable(this.mG, flags);
        dest.writeParcelable(this.k, flags);
        dest.writeParcelable(this.fE, flags);
        dest.writeParcelable(this.zN, flags);
        dest.writeParcelable(this.p, flags);
        dest.writeParcelable(this.vITARAE, flags);
        dest.writeParcelable(this.vITC, flags);
        dest.writeParcelable(this.tHIA, flags);
        dest.writeParcelable(this.rIBF, flags);
        dest.writeParcelable(this.nIA, flags);
        dest.writeParcelable(this.vITB6A, flags);
        dest.writeParcelable(this.fOLDFE, flags);
        dest.writeParcelable(this.fOLFD, flags);
        dest.writeParcelable(this.fOLAC, flags);
        dest.writeParcelable(this.vITB12, flags);
        dest.writeParcelable(this.vITD, flags);
        dest.writeParcelable(this.tOCPHA, flags);
        dest.writeParcelable(this.vITK1, flags);
        dest.writeParcelable(this.wATER, flags);
    }

    public Nutrients() {
    }

    protected Nutrients(Parcel in) {
        this.eNERCKCAL = in.readParcelable(ENERCKCAL.class.getClassLoader());
        this.fAT = in.readParcelable(FAT.class.getClassLoader());
        this.fASAT = in.readParcelable(FASAT.class.getClassLoader());
        this.fATRN = in.readParcelable(FATRN.class.getClassLoader());
        this.fAMS = in.readParcelable(FAMS.class.getClassLoader());
        this.fAPU = in.readParcelable(FAPU.class.getClassLoader());
        this.cHOCDF = in.readParcelable(CHOCDF.class.getClassLoader());
        this.fIBTG = in.readParcelable(FIBTG.class.getClassLoader());
        this.sUGAR = in.readParcelable(SUGAR.class.getClassLoader());
        this.pROCNT = in.readParcelable(PROCNT.class.getClassLoader());
        this.cHOLE = in.readParcelable(CHOLE.class.getClassLoader());
        this.nA = in.readParcelable(NA.class.getClassLoader());
        this.cA = in.readParcelable(CA.class.getClassLoader());
        this.mG = in.readParcelable(MG.class.getClassLoader());
        this.k = in.readParcelable(K.class.getClassLoader());
        this.fE = in.readParcelable(FE.class.getClassLoader());
        this.zN = in.readParcelable(ZN.class.getClassLoader());
        this.p = in.readParcelable(P.class.getClassLoader());
        this.vITARAE = in.readParcelable(VITARAE.class.getClassLoader());
        this.vITC = in.readParcelable(VITC.class.getClassLoader());
        this.tHIA = in.readParcelable(THIA.class.getClassLoader());
        this.rIBF = in.readParcelable(RIBF.class.getClassLoader());
        this.nIA = in.readParcelable(NIA.class.getClassLoader());
        this.vITB6A = in.readParcelable(VITB6A.class.getClassLoader());
        this.fOLDFE = in.readParcelable(FOLDFE.class.getClassLoader());
        this.fOLFD = in.readParcelable(FOLFD.class.getClassLoader());
        this.fOLAC = in.readParcelable(FOLAC.class.getClassLoader());
        this.vITB12 = in.readParcelable(VITB12.class.getClassLoader());
        this.vITD = in.readParcelable(VITD.class.getClassLoader());
        this.tOCPHA = in.readParcelable(TOCPHA.class.getClassLoader());
        this.vITK1 = in.readParcelable(VITK1.class.getClassLoader());
        this.wATER = in.readParcelable(WATER.class.getClassLoader());
    }

    public static final Parcelable.Creator<Nutrients> CREATOR = new Parcelable.Creator<Nutrients>() {
        @Override
        public Nutrients createFromParcel(Parcel source) {
            return new Nutrients(source);
        }

        @Override
        public Nutrients[] newArray(int size) {
            return new Nutrients[size];
        }
    };
}

 class CA implements Parcelable {
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public CA() {
     }

     protected CA(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<CA> CREATOR = new Parcelable.Creator<CA>() {
         @Override
         public CA createFromParcel(Parcel source) {
             return new CA(source);
         }

         @Override
         public CA[] newArray(int size) {
             return new CA[size];
         }
     };
 }

 class CHOCDF implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public CHOCDF() {
     }

     protected CHOCDF(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<CHOCDF> CREATOR = new Parcelable.Creator<CHOCDF>() {
         @Override
         public CHOCDF createFromParcel(Parcel source) {
             return new CHOCDF(source);
         }

         @Override
         public CHOCDF[] newArray(int size) {
             return new CHOCDF[size];
         }
     };
 }

 class CHOLE implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }
    
    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public CHOLE() {
     }

     protected CHOLE(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<CHOLE> CREATOR = new Parcelable.Creator<CHOLE>() {
         @Override
         public CHOLE createFromParcel(Parcel source) {
             return new CHOLE(source);
         }

         @Override
         public CHOLE[] newArray(int size) {
             return new CHOLE[size];
         }
     };
 }

 class ENERCKCAL implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public ENERCKCAL() {
     }

     protected ENERCKCAL(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<ENERCKCAL> CREATOR = new Parcelable.Creator<ENERCKCAL>() {
         @Override
         public ENERCKCAL createFromParcel(Parcel source) {
             return new ENERCKCAL(source);
         }

         @Override
         public ENERCKCAL[] newArray(int size) {
             return new ENERCKCAL[size];
         }
     };
 }

 class FAMS implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public FAMS() {
     }

     protected FAMS(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<FAMS> CREATOR = new Parcelable.Creator<FAMS>() {
         @Override
         public FAMS createFromParcel(Parcel source) {
             return new FAMS(source);
         }

         @Override
         public FAMS[] newArray(int size) {
             return new FAMS[size];
         }
     };
 }

 class FAPU implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public FAPU() {
     }

     protected FAPU(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<FAPU> CREATOR = new Parcelable.Creator<FAPU>() {
         @Override
         public FAPU createFromParcel(Parcel source) {
             return new FAPU(source);
         }

         @Override
         public FAPU[] newArray(int size) {
             return new FAPU[size];
         }
     };
 }

class FASAT implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public FASAT() {
    }

    protected FASAT(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<FASAT> CREATOR = new Parcelable.Creator<FASAT>() {
        @Override
        public FASAT createFromParcel(Parcel source) {
            return new FASAT(source);
        }

        @Override
        public FASAT[] newArray(int size) {
            return new FASAT[size];
        }
    };
}

 class FAT implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public FAT() {
     }

     protected FAT(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<FAT> CREATOR = new Parcelable.Creator<FAT>() {
         @Override
         public FAT createFromParcel(Parcel source) {
             return new FAT(source);
         }

         @Override
         public FAT[] newArray(int size) {
             return new FAT[size];
         }
     };
 }

class FATRN implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public FATRN() {
    }

    protected FATRN(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<FATRN> CREATOR = new Parcelable.Creator<FATRN>() {
        @Override
        public FATRN createFromParcel(Parcel source) {
            return new FATRN(source);
        }

        @Override
        public FATRN[] newArray(int size) {
            return new FATRN[size];
        }
    };
}

 class FE implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public FE() {
     }

     protected FE(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<FE> CREATOR = new Parcelable.Creator<FE>() {
         @Override
         public FE createFromParcel(Parcel source) {
             return new FE(source);
         }

         @Override
         public FE[] newArray(int size) {
             return new FE[size];
         }
     };
 }

class FIBTG implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public FIBTG() {
    }

    protected FIBTG(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<FIBTG> CREATOR = new Parcelable.Creator<FIBTG>() {
        @Override
        public FIBTG createFromParcel(Parcel source) {
            return new FIBTG(source);
        }

        @Override
        public FIBTG[] newArray(int size) {
            return new FIBTG[size];
        }
    };
}

class FOLAC implements Parcelable {


    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public FOLAC() {
    }

    protected FOLAC(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<FOLAC> CREATOR = new Parcelable.Creator<FOLAC>() {
        @Override
        public FOLAC createFromParcel(Parcel source) {
            return new FOLAC(source);
        }

        @Override
        public FOLAC[] newArray(int size) {
            return new FOLAC[size];
        }
    };
}

class FOLDFE implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public FOLDFE() {
    }

    protected FOLDFE(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<FOLDFE> CREATOR = new Parcelable.Creator<FOLDFE>() {
        @Override
        public FOLDFE createFromParcel(Parcel source) {
            return new FOLDFE(source);
        }

        @Override
        public FOLDFE[] newArray(int size) {
            return new FOLDFE[size];
        }
    };
}

 class FOLFD implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public FOLFD() {
     }

     protected FOLFD(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<FOLFD> CREATOR = new Parcelable.Creator<FOLFD>() {
         @Override
         public FOLFD createFromParcel(Parcel source) {
             return new FOLFD(source);
         }

         @Override
         public FOLFD[] newArray(int size) {
             return new FOLFD[size];
         }
     };
 }

 class K implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public K() {
     }

     protected K(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<K> CREATOR = new Parcelable.Creator<K>() {
         @Override
         public K createFromParcel(Parcel source) {
             return new K(source);
         }

         @Override
         public K[] newArray(int size) {
             return new K[size];
         }
     };
 }

 class MG implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public MG() {
     }

     protected MG(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<MG> CREATOR = new Parcelable.Creator<MG>() {
         @Override
         public MG createFromParcel(Parcel source) {
             return new MG(source);
         }

         @Override
         public MG[] newArray(int size) {
             return new MG[size];
         }
     };
 }

 class NA implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public NA() {
     }

     protected NA(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<NA> CREATOR = new Parcelable.Creator<NA>() {
         @Override
         public NA createFromParcel(Parcel source) {
             return new NA(source);
         }

         @Override
         public NA[] newArray(int size) {
             return new NA[size];
         }
     };
 }

 class NIA implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public NIA() {
     }

     protected NIA(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<NIA> CREATOR = new Parcelable.Creator<NIA>() {
         @Override
         public NIA createFromParcel(Parcel source) {
             return new NIA(source);
         }

         @Override
         public NIA[] newArray(int size) {
             return new NIA[size];
         }
     };
 }

 class P implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public P() {
     }

     protected P(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<P> CREATOR = new Parcelable.Creator<P>() {
         @Override
         public P createFromParcel(Parcel source) {
             return new P(source);
         }

         @Override
         public P[] newArray(int size) {
             return new P[size];
         }
     };
 }

 class PROCNT implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public PROCNT() {
     }

     protected PROCNT(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<PROCNT> CREATOR = new Parcelable.Creator<PROCNT>() {
         @Override
         public PROCNT createFromParcel(Parcel source) {
             return new PROCNT(source);
         }

         @Override
         public PROCNT[] newArray(int size) {
             return new PROCNT[size];
         }
     };
 }

 class RIBF implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public RIBF() {
     }

     protected RIBF(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<RIBF> CREATOR = new Parcelable.Creator<RIBF>() {
         @Override
         public RIBF createFromParcel(Parcel source) {
             return new RIBF(source);
         }

         @Override
         public RIBF[] newArray(int size) {
             return new RIBF[size];
         }
     };
 }
 class SUGAR implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public SUGAR() {
     }

     protected SUGAR(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<SUGAR> CREATOR = new Parcelable.Creator<SUGAR>() {
         @Override
         public SUGAR createFromParcel(Parcel source) {
             return new SUGAR(source);
         }

         @Override
         public SUGAR[] newArray(int size) {
             return new SUGAR[size];
         }
     };
 }
 class THIA implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public THIA() {
     }

     protected THIA(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<THIA> CREATOR = new Parcelable.Creator<THIA>() {
         @Override
         public THIA createFromParcel(Parcel source) {
             return new THIA(source);
         }

         @Override
         public THIA[] newArray(int size) {
             return new THIA[size];
         }
     };
 }
 class TOCPHA implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public TOCPHA() {
     }

     protected TOCPHA(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<TOCPHA> CREATOR = new Parcelable.Creator<TOCPHA>() {
         @Override
         public TOCPHA createFromParcel(Parcel source) {
             return new TOCPHA(source);
         }

         @Override
         public TOCPHA[] newArray(int size) {
             return new TOCPHA[size];
         }
     };
 }
 class VITARAE implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public VITARAE() {
     }

     protected VITARAE(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<VITARAE> CREATOR = new Parcelable.Creator<VITARAE>() {
         @Override
         public VITARAE createFromParcel(Parcel source) {
             return new VITARAE(source);
         }

         @Override
         public VITARAE[] newArray(int size) {
             return new VITARAE[size];
         }
     };
 }
 class VITB12 implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public VITB12() {
     }

     protected VITB12(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<VITB12> CREATOR = new Parcelable.Creator<VITB12>() {
         @Override
         public VITB12 createFromParcel(Parcel source) {
             return new VITB12(source);
         }

         @Override
         public VITB12[] newArray(int size) {
             return new VITB12[size];
         }
     };
 }
 class VITB6A implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public VITB6A() {
     }

     protected VITB6A(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<VITB6A> CREATOR = new Parcelable.Creator<VITB6A>() {
         @Override
         public VITB6A createFromParcel(Parcel source) {
             return new VITB6A(source);
         }

         @Override
         public VITB6A[] newArray(int size) {
             return new VITB6A[size];
         }
     };
 }
 class VITC implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public VITC() {
     }

     protected VITC(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<VITC> CREATOR = new Parcelable.Creator<VITC>() {
         @Override
         public VITC createFromParcel(Parcel source) {
             return new VITC(source);
         }

         @Override
         public VITC[] newArray(int size) {
             return new VITC[size];
         }
     };
 }
 class VITD implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeValue(this.quantity);
         dest.writeString(this.unit);
     }

     public VITD() {
     }

     protected VITD(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Parcelable.Creator<VITD> CREATOR = new Parcelable.Creator<VITD>() {
         @Override
         public VITD createFromParcel(Parcel source) {
             return new VITD(source);
         }

         @Override
         public VITD[] newArray(int size) {
             return new VITD[size];
         }
     };
 }
class VITK1 implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public VITK1() {
    }

    protected VITK1(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<VITK1> CREATOR = new Parcelable.Creator<VITK1>() {
        @Override
        public VITK1 createFromParcel(Parcel source) {
            return new VITK1(source);
        }

        @Override
        public VITK1[] newArray(int size) {
            return new VITK1[size];
        }
    };
}
class WATER implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public WATER() {
    }

    protected WATER(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<WATER> CREATOR = new Parcelable.Creator<WATER>() {
        @Override
        public WATER createFromParcel(Parcel source) {
            return new WATER(source);
        }

        @Override
        public WATER[] newArray(int size) {
            return new WATER[size];
        }
    };
}
class ZN implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeValue(this.quantity);
        dest.writeString(this.unit);
    }

    public ZN() {
    }

    protected ZN(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<ZN> CREATOR = new Parcelable.Creator<ZN>() {
        @Override
        public ZN createFromParcel(Parcel source) {
            return new ZN(source);
        }

        @Override
        public ZN[] newArray(int size) {
            return new ZN[size];
        }
    };
}

