package com.test;

public class Doner {
  private final String ekmekTuru;
  private final String etTuru;
  private final boolean sogan;
  private final boolean yesillik;
  private final boolean tursu;

  public static class Builder {
    private final String ekmekTuru;
    private final String etTuru;

    private boolean sogan = true;
    private boolean yesillik = true;
    private boolean tursu = false;

    public Builder(EkmekTuruType ekmekTuru, EtTuruType etTuru) {
      this.ekmekTuru = ekmekTuru.name();
      this.etTuru = etTuru.name();
      System.out.println("builder initialized");
      System.out.println(this.toString());
    }

    public Builder setSogan(boolean sogan) {
      this.sogan = sogan;
      System.out.println("sogan");
      return this;
    }

    public Builder setYesillik(boolean yesillik) {
      this.yesillik = yesillik;
      System.out.println("yesillik");
      return this;
    }

    public Builder setTursu(boolean tursu) {
      this.tursu = tursu;
      System.out.println("tursu");
      return this;
    }

    public Builder herzamankinden() {
      this.tursu = true;
      this.yesillik = true;
      this.sogan = true;
      return this;
    }

    public Builder sogansiz() {
      this.tursu = true;
      this.yesillik = true;
      this.sogan = false;
      return this;
    }

    public Doner build() {
      System.out.println("doner building");
      return new Doner(this);
    }

    @Override
    public String toString() {
      return "Builder{" +
          "ekmekTuru='" + ekmekTuru + '\'' +
          ", etTuru='" + etTuru + '\'' +
          ", sogan=" + sogan +
          ", yesillik=" + yesillik +
          ", tursu=" + tursu +
          '}';
    }
  }

  public enum EkmekTuruType {
    SOMUN,
    LAVAS,
    SOMUN_ICINI_AL
  }

  public enum EtTuruType {
    TAVUK,
    DANA,
    HINDI
  }

  public Doner(Builder builder) {
    this.ekmekTuru = builder.ekmekTuru;
    this.etTuru = builder.etTuru;
    this.sogan = builder.sogan;
    this.yesillik = builder.yesillik;
    this.tursu = builder.tursu;
  }

  @Override
  public String toString() {
    return "Doner{" +
        "ekmekTuru='" + ekmekTuru + '\'' +
        ", etTuru='" + etTuru + '\'' +
        ", sogan=" + sogan +
        ", yesillik=" + yesillik +
        ", tursu=" + tursu +
        '}';
  }
}
