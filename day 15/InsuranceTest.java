    package com.codinghusttle.real.hospitalManagemnet;

    import com.codinghusttle.real.hospitalManagemnet.Service.InsuranceService;
    import com.codinghusttle.real.hospitalManagemnet.entity.Insurance;
    import com.codinghusttle.real.hospitalManagemnet.entity.Patient;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;

    import java.time.LocalDate;

    @SpringBootTest
    public class InsuranceTest {

        @Autowired
        private InsuranceService insuranceService;


        @Test
        public void testInsurance(){
            Insurance insurance = Insurance.builder()
                    .PolicyNumber("HDFC222")
                    .provider("HDFC")
                    .validUntil(LocalDate.of(2050,12,31)).build();

       Patient patient =  insuranceService.AssignInsuranceToPatient(insurance , 1L);
            System.out.println(patient);
        }

    }
