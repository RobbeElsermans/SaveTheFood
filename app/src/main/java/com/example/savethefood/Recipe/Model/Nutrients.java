package com.example.savethefood.Recipe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.savethefood.Recipe.Model.NutrientsClasses.CA;
import com.example.savethefood.Recipe.Model.NutrientsClasses.CHOCDF;
import com.example.savethefood.Recipe.Model.NutrientsClasses.CHOLE;
import com.example.savethefood.Recipe.Model.NutrientsClasses.ENERCKCAL;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FAMS;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FAPU;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FASAT;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FAT;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FATRN;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FE;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FIBTG;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FOLAC;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FOLDFE;
import com.example.savethefood.Recipe.Model.NutrientsClasses.FOLFD;
import com.example.savethefood.Recipe.Model.NutrientsClasses.K;
import com.example.savethefood.Recipe.Model.NutrientsClasses.MG;
import com.example.savethefood.Recipe.Model.NutrientsClasses.NA;
import com.example.savethefood.Recipe.Model.NutrientsClasses.NIA;
import com.example.savethefood.Recipe.Model.NutrientsClasses.P;
import com.example.savethefood.Recipe.Model.NutrientsClasses.PROCNT;
import com.example.savethefood.Recipe.Model.NutrientsClasses.RIBF;
import com.example.savethefood.Recipe.Model.NutrientsClasses.SUGAR;
import com.example.savethefood.Recipe.Model.NutrientsClasses.THIA;
import com.example.savethefood.Recipe.Model.NutrientsClasses.TOCPHA;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITARAE;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITB12;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITB6A;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITC;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITD;
import com.example.savethefood.Recipe.Model.NutrientsClasses.VITK1;
import com.example.savethefood.Recipe.Model.NutrientsClasses.WATER;
import com.example.savethefood.Recipe.Model.NutrientsClasses.ZN;
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

