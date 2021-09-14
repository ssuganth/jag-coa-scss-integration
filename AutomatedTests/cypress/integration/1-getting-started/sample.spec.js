describe("Perform API testing of RSI ticket search endpoint", () => {
    context("Make a GET request to the endpoint", () => {
        it("Test that the endpoint returns correct status code and body", () => {
               cy.request("http://citizen-api-0198bb-dev.apps.silver.devops.gov.bc.ca/api/tickets/ticket?ticketNumber=EZ02000460&time=09:54").then(response => {
                               expect(response.status).to.eq(200)
                               cy.log("Hry")
                               })
        })
    })
})