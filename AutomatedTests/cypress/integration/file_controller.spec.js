describe('File Controller Tests', () => {

   it('Filenumbersearch test good result', () => {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "text/xml");
      myHeaders.append("Cookie", "ssnid=885f8220165311ecaf81c6d7dc943fe7");
      cy.request({
         method: 'POST',
         headers: myHeaders,
         url: Cypress.env('wm_host'),
         redirect: 'follow',
         body:
            `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
         <soapenv:Header/>
         <soapenv:Body>
            <scss:fileNumberSearch>
               <filter>
                  <courtFileNumber>9950</courtFileNumber>
                  <locationId>16218.0026</locationId>
                  <courtLevelCode>P</courtLevelCode>
                  <courtClassCode>F</courtClassCode>
               </filter>
            </scss:fileNumberSearch>
         </soapenv:Body>
      </soapenv:Envelope>`
      }).then((response) => {
         cy.log(response.body)
         expect(response.body)
      })
   })
})
