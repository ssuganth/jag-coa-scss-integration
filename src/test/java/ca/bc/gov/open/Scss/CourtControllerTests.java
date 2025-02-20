package ca.bc.gov.open.Scss;

import static org.mockito.Mockito.when;

import ca.bc.gov.open.Scss.Controllers.CourtController;
import com.example.demp.wsdl.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CourtControllerTests {

    @Autowired private CourtController courtController;

    @Mock private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getCourtFileTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var gcf = new GetCourtFile();
        gcf.setPhysicalFileId(BigDecimal.ONE);

        //    Init response
        var cfr = new GetCourtFileResponse();
        CourtFile cf = new CourtFile();
        cf.setCourtClassCode("A");
        cf.setCourtLevelCode("A");
        cf.setCourtFileNumber("A");
        cf.setLocationId(BigDecimal.ONE);
        cf.setPhysicalFileId(BigDecimal.ONE);
        cf.setStyleOfCause("A");
        cfr.setCourtFile(cf);

        ResponseEntity<GetCourtFileResponse> responseEntity =
                new ResponseEntity<>(cfr, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<GetCourtFileResponse>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.getCourtFile(gcf);

        //     Assert response is correct
        assert (out.equals(cfr));
    }

    @Test
    public void getCourtBasicsTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var gcb = new GetCourtBasics();
        gcb.setPhysicalFileId(BigDecimal.ONE);

        //    Init response
        CaseBasics cb = new CaseBasics();
        cb.setCourtClassCode("A");
        cb.setCourtLevelCode("A");
        cb.setPhysicalFileId(BigDecimal.ONE);
        Issue is = new Issue();
        is.setIssueDescription("A");
        is.setIssueTypeCode("A");
        cb.setIssues(Collections.singletonList(is));
        cb.setFileAccessLevelCode("A");
        cb.setLocationId(BigDecimal.ONE);

        ResponseEntity<CaseBasics> responseEntity = new ResponseEntity<>(cb, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<CaseBasics>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.getCourtBasics(gcb);

        //     Assert response is correct
        assert (out.getCaseBasics().equals(cb));
    }

    @Test
    public void getCeisConnectInfoTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var ci = new GetCeisConnectInfo();

        var cir = new GetCeisConnectInfoResponse();
        cir.setConnectionInfo("A");

        ResponseEntity<GetCeisConnectInfoResponse> responseEntity =
                new ResponseEntity<>(cir, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<GetCeisConnectInfoResponse>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.getCeisConnectInfo(ci);

        //     Assert response is correct
        assert cir.equals(out);
    }

    @Test
    public void getPartiesTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var gp = new GetParties();
        gp.setPhysicalFileId(BigDecimal.ONE);

        //    Init response
        var cb = new GetPartiesResponse();
        CaseParty cp = new CaseParty();
        cp.setActive(true);
        cp.setFirstName("A");
        cp.setAddressFirstLine("A");
        cp.setCity("A");
        cp.setAddressSecondLine("A");
        cp.setCounselName("A");
        cp.setCounselPhoneNumber("A");
        cp.setOrganizationName("A");
        cp.setPartyId(BigDecimal.ONE);
        cp.setExtensionNumber("A");
        cp.setPartyRoleCode("A");
        cp.setPartyTypeCode("A");
        cp.setPostalCode("A");
        cp.setSelfRepresented(true);
        cp.setSurname("A");
        cp.setProvince("A");
        cp.setPhoneNumber("A");

        cb.setParties(Collections.singletonList(cp));
        ResponseEntity<GetPartiesResponse> responseEntity = new ResponseEntity<>(cb, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<GetPartiesResponse>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.getParties(gp);

        //     Assert response is correct
        assert (out.equals(cb));
    }

    @Test
    public void partNameSearchTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var pns = new PartyNameSearch();
        PartyNameSearchFilter pnf = new PartyNameSearchFilter();
        pnf.setCourtClass("A");
        pnf.setAgencyId(BigDecimal.ONE);
        pnf.setSearchType("A");
        pnf.setFirstName("A");
        pnf.setCourtLevel("A");
        pnf.setPage(BigDecimal.ONE);
        pnf.setName("A");
        pnf.setRoleType("A");
        pns.setFilter(pnf);

        //    Init response
        SearchResults res = new SearchResults();
        res.setPage(BigDecimal.ONE);
        res.setRecordsPerPage(BigDecimal.ONE);
        res.setTotalRecords(BigDecimal.ONE);
        res.setResults(Collections.singletonList(new CourtFile()));

        ResponseEntity<SearchResults> responseEntity = new ResponseEntity<>(res, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<SearchResults>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.partyNameSearch(pns);

        //     Assert response is correct
        assert (out.getSearchResults().equals(res));
    }

    @Test
    public void partNameSearchNullFilterTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        //    Init request object
        var pns = new PartyNameSearch();

        //    Init response
        SearchResults res = new SearchResults();

        ResponseEntity<SearchResults> responseEntity = new ResponseEntity<>(res, HttpStatus.OK);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.GET),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<SearchResults>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.partyNameSearch(pns);

        //     Assert response is correct
        assert (out.getSearchResults().equals(res));
    }

    @Test
    public void saveHearingResultTest() {
        //  Init service under test
        courtController = new CourtController(restTemplate);

        ResponseEntity<String> responseEntity = new ResponseEntity<>("", HttpStatus.OK);

        var hr = new SaveHearingResults();
        var res = new HearingResult();
        var res2 = new HearingResult2();
        var cd = new CaseDetails();
        cd.setCaseFiling("A");
        cd.setCaseTrackingID(BigDecimal.ONE);

        var ca = new CaseAugmentation();
        var ch = new CaseHearing();
        var ea = new CourtEventAppearance();
        ea.setActivityStatus("A");
        ea.setCourtAppearanceCourt("A");
        ea.setActivityStatus("A");
        ea.setCancellationStatus("A");
        ea.setCourtAppearanceDate(Instant.now());
        ea.setCourtAppearanceCategoryText("A");
        ea.setCourtEventSequenceID("A");

        var tm = new TimeMeasureDetails();
        tm.setMeasureText(BigDecimal.ONE);
        tm.setMeasureEstimatedIndicator(true);
        tm.setMeasureUnitText("A");

        ea.setTimeMeasureDetails(tm);
        ch.setCourtEventAppearance(ea);
        ca.setCaseHearing(ch);
        cd.setCaseAugmentation(ca);
        res2.setCaseDetails(cd);
        res.setHearingResult(res2);
        hr.setHearingResult(res);

        //     Set up to mock ords response
        when(restTemplate.exchange(
                        Mockito.any(String.class),
                        Mockito.eq(HttpMethod.POST),
                        Mockito.<HttpEntity<String>>any(),
                        Mockito.<Class<String>>any()))
                .thenReturn(responseEntity);

        //     Do request
        var out = courtController.saveHearingResults(hr);

        assert out != null;
    }
}
