Feature: Invoicing customers

  Scenario: Batch Invoice
    Given on a certain day '2017-02-10'
    When processing invoices
    Then merchant 'A' receive invoice

  Scenario: Batch Invoice
    Given on a certain day '2017-02-10'
    When processing invoices
    Then merchant 'A' receive invoice
    
    