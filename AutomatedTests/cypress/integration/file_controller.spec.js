describe('File Controller Tests', () => {

   it('tests the FileNumberSearch successful response', () => {
      cy.request({
         url: Cypress.env("scss_host") + 'ws/',
         method: 'POST',
         headers: {
            authorization: Cypress.env("scss_token"),
            'Content-Type': "text/xml"
         },
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
         expect(response.status).to.eq(200)
         cy.readFile("./cypress/ExampleRequests/getFileNumberSearchV1.xml").should("eq",response.body.replace(/\s/g,''))
      })
   })

   xit('tests the linkFiles successful response', () => {
         cy.request({
            url: Cypress.env("scss_host") + 'ws/',
            method: 'POST',
            headers: {
               authorization: Cypress.env("scss_token"),
               'Content-Type': "text/xml"
            },
            redirect: 'follow',
            body:
               `<soapenv:Envelope xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope" xmlns:scss="http://brooks/SCSS.Source.CeisScss.ws.provider:CeisScss">
                   <soapenv:Header/>
                   <soapenv:Body>
                      <scss:linkFile>
                         <physicalFileId>688</physicalFileId>
                         <caseActionNumber>SC000185</caseActionNumber>
                      </scss:linkFile>
                   </soapenv:Body>
                </soapenv:Envelope>`
         }).then((response) => {
            expect(response.status).to.eq(200)
            cy.readFile("./cypress/ExampleRequests/getFileNumberSearchV1.xml").should("eq",response.body.replace(/\s/g,''))
         })
      })
})
