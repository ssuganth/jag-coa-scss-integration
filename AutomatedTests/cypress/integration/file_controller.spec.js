describe('File Controller Tests', () => {

   beforeEach(() => {
      login();
      Cypress.Cookies.preserveOnce('session_id', 'remember_token');
});

   it('Filenumbersearch test good result', () => {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "text/xml");
      myHeaders.append("Authorization", Cypress.env('wm_token'));
      myHeaders.append("Cookie",  Cypress.env('ssid'));
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
