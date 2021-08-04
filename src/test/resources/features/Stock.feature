Feature: User tries to register a stock in stock manager

Scenario Outline: Creating a new stock in stock manager 
	Given a stockId '<stockId>' and its description '<description>'
	When access the /stock route
	Then the stock is created and the response status will be <status>
	
	Examples: 
	| stockId  |     description    | status |
	| mglu3    |    Magazine Luiza  |  200   |
	| bbdc3    |    Banco Bradesco  |  200   |

