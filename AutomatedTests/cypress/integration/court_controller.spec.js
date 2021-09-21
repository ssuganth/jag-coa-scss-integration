describe('Court Controller Tests', () => {

  it('Test Get Court File Api', () => {
    var payload = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
    <soapenv:Header/>
    <soapenv:Body>
       <scss:getCourtFile>
          <physicalFileId>688</physicalFileId>
       </scss:getCourtFile>
    </soapenv:Body>
 </soapenv:Envelope>`

    cy.request({
      url: Cypress.env("scss_host") + 'ws/',
      body: payload,
      method: 'POST',
      headers: {
        authorization: Cypress.env("scss_token")
      }
    }).then((response) => {
      expect(response.status).to.eq(200)
      cy.readFile("./cypress/ExampleRequests/getCourtFileV1.xml").should("eq", response.body)
    })
  })

  it('Test Get Court Basics Api', () => {
    var payload = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
    <soapenv:Header/>
    <soapenv:Body>
       <scss:getCourtBasics>
          <physicalFileId>8000005</physicalFileId>
       </scss:getCourtBasics>
    </soapenv:Body>
 </soapenv:Envelope>`

    cy.request({
      url: Cypress.env("scss_host") + 'ws/',
      body: payload,
      method: 'POST',
      headers: {
        authorization: Cypress.env("scss_token")
      }
    }).then((response) => {
      expect(response.status).to.eq(200)
      cy.readFile("./cypress/ExampleRequests/getCourtBasicsV1.xml").should("eq", response.body)
    })
  })

  it('Test Get Ceis Connect Info Api', () => {
    var payload = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
    <soapenv:Header/>
    <soapenv:Body>
       <scss:getCeisConnectInfo/>
    </soapenv:Body>
 </soapenv:Envelope>`

    cy.request({
      url: Cypress.env("scss_host") + 'ws/',
      body: payload,
      method: 'POST',
      headers: {
        authorization: Cypress.env("scss_token")
      }
    }).then((response) => {
      expect(response.status).to.eq(200)
      cy.readFile("./cypress/ExampleRequests/getCeisConnectInfoV1.xml").should("eq", response.body)
    })
  })


  it('Test Save Hearing Result Api', () => {
    var payload = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
    <soapenv:Header/>
    <soapenv:Body>
       <scss:saveHearingResults>
          <hearingResult>
             <HearingResult>
                <CaseDetails>
                   <CaseTrackingID>11</CaseTrackingID>
                   <CaseFiling>2222</CaseFiling>
                   <CaseAugmentation>
                      <CaseHearing>
                         <CourtEventAppearance>
                            <CourtAppearanceCourt>11</CourtAppearanceCourt>
                            <CourtAppearanceDate>03-SEP-11</CourtAppearanceDate>
                            <CourtAppearanceCategoryText>APN</CourtAppearanceCategoryText>
                            <CourtEventSequenceID>?</CourtEventSequenceID>
                            <ActivityStatus>NOT PROCEDING</ActivityStatus>
                            <CancellationStatus>Abandoned</CancellationStatus>
                            <TimeMeasureDetails>
                               <MeasureText>?</MeasureText>
                               <MeasureUnitText>?</MeasureUnitText>
                               <MeasureEstimatedIndicator>?</MeasureEstimatedIndicator>
                            </TimeMeasureDetails>
                         </CourtEventAppearance>
                      </CaseHearing>
                   </CaseAugmentation>
                </CaseDetails>
             </HearingResult>
          </hearingResult>
       </scss:saveHearingResults>
    </soapenv:Body>
 </soapenv:Envelope>`

    cy.request({
      url: Cypress.env("scss_host") + 'ws/',
      body: payload,
      method: 'POST',
      headers: {
        authorization: Cypress.env("scss_token")
      }
    }).then((response) => {
      expect(response.status).to.eq(200)
      cy.readFile("./cypress/ExampleRequests/saveHearingResultV1.xml").should("eq", response.body)
    })
  })

})
