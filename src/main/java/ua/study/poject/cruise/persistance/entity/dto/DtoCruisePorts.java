package ua.study.poject.cruise.persistance.entity.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ua.study.poject.cruise.persistance.entity.Ship;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class DtoCruisePorts implements Serializable {

    private static final long serialVersionUID = -3898724218920081018L;

    Ship selectedship;

    public double priceFirstClass;
    public double priceSecondClass;
    public double priceThirdClass;
    public double priceFourthClass;

    public Long selectedportstart;
    public LocalDateTime datestart;

    public Long selectedport1;
    public LocalDateTime date1in;
    public LocalDateTime date1out;

    public Long selectedport2;
    public LocalDateTime date2in;
    public LocalDateTime date2out;

    public Long selectedport3;
    public LocalDateTime date3in;
    public LocalDateTime date3out;

    public Long selectedport4;
    public LocalDateTime date4in;
    public LocalDateTime date4out;

    public Long selectedport5;
    public LocalDateTime date5in;
    public LocalDateTime date5out;

    public Long selectedport6;
    public LocalDateTime date6in;
    public LocalDateTime date6out;

    public Long selectedport7;
    public LocalDateTime date7in;
    public LocalDateTime date7out;

    public Long selectedportstop;
    public LocalDateTime datestop;

    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void setSelectedship(Ship selectedship) {
        this.selectedship = selectedship;
    }

    public void setPriceFirstClass(double priceFirstClass) {
        this.priceFirstClass = priceFirstClass;
    }

    public void setPriceSecondClass(double priceSecondClass) {
        this.priceSecondClass = priceSecondClass;
    }

    public void setPriceThirdClass(double priceThirdClass) {
        this.priceThirdClass = priceThirdClass;
    }

    public void setPriceFourthClass(double priceFourthClass) {
        this.priceFourthClass = priceFourthClass;
    }

    public void setSelectedportstart(Long selectedportstart) {
        this.selectedportstart = selectedportstart;
    }

    public void setDatestart(String datestart) { // dddddddddddddd
        if (!datestart.equals(""))
            this.datestart = LocalDateTime.parse(datestart, formatter);
    }

    public void setSelectedport1(Long selectedport1) {
        this.selectedport1 = selectedport1;
    }

    public void setDate1in(String date1in) {
        if (!date1in.equals(""))
            this.date1in = LocalDateTime.parse(date1in, formatter);
    }

    public void setDate1out(String date1out) {
        if (!date1out.equals(""))
            this.date1out = LocalDateTime.parse(date1out, formatter);
    }

    public void setSelectedport2(Long selectedport2) {
        this.selectedport2 = selectedport2;
    }

    public void setDate2in(String date2in) {
        if(!date2in.equals(""))
        this.date2in = LocalDateTime.parse(date2in, formatter);
    }

    public void setDate2out(String date2out) {
        if(!date2out.equals(""))
        this.date2out = LocalDateTime.parse(date2out, formatter);
    }

    public void setSelectedport3(Long selectedport3) {
        this.selectedport3 = selectedport3;
    }

    public void setDate3in(String date3in) {
        if(!date3in.equals(""))
        this.date3in = LocalDateTime.parse(date3in, formatter);
    }

    public void setDate3out(String date3out) {
        if(!date3out.equals(""))
        this.date3out = LocalDateTime.parse(date3out, formatter);
    }

    public void setSelectedport4(Long selectedport4) {
        this.selectedport4 = selectedport4;
    }

    public void setDate4in(String date4in) {
        if(!date4in.equals(""))
        this.date4in = LocalDateTime.parse(date4in, formatter);
    }

    public void setDate4out(String date4out) {
        if(!date4out.equals(""))
        this.date4out = LocalDateTime.parse(date4out, formatter);
    }

    public void setSelectedport5(Long selectedport5) {
        this.selectedport5 = selectedport5;
    }

    public void setDate5in(String date5in) {
        if(!date5in.equals(""))
        this.date5in = LocalDateTime.parse(date5in, formatter);
    }

    public void setDate5out(String date5out) {
        if(!date5out.equals(""))
        this.date5out = LocalDateTime.parse(date5out, formatter);
    }

    public void setSelectedport6(Long selectedport6) {
        this.selectedport6 = selectedport6;
    }

    public void setDate6in(String date6in) {
        if(!date6in.equals(""))
        this.date6in = LocalDateTime.parse(date6in, formatter);
    }

    public void setDate6out(String date6out) {
        if(!date6out.equals(""))
        this.date6out = LocalDateTime.parse(date6out, formatter);
    }

    public void setSelectedport7(Long selectedport7) {
        this.selectedport7 = selectedport7;
    }

    public void setDate7in(String date7in) {
        if(!date7in.equals(""))
        this.date7in = LocalDateTime.parse(date7in, formatter);
    }

    public void setDate7out(String date7out) {
        if(!date7out.equals(""))
        this.date7out = LocalDateTime.parse(date7out, formatter);
    }

    public void setSelectedportstop(Long selectedportstop) {
        this.selectedportstop = selectedportstop;
    }

    public void setDatestop(String datestop) {
        if(!datestop.equals(""))
        this.datestop = LocalDateTime.parse(datestop, formatter);
    }
}
