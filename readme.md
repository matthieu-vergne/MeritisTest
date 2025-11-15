# Starter

1. Present dummy code:
	- set of operations on 1 double
	- use some conf
	- keep it simple to focus on testing
1. JUnit Test
	- 1 test for all linears
1. Mockito
	- mock conf to control parameters
1. Hamcrest
	- more intuitive assertions

# Basics

1. Don't stop testing on first failure
	- Separate your tests
1. Distinguish broken vs failed test
	- Investigate from failures
1. Name your tests
	- Make the test report tells you what is wrong

# Start designing

1. Factor your code
	- Abstract the low level details
1. Factor your tests
	- List test cases rather than writing new tests
1. Exploit your abstractions
	- Same concepts for code and tests, toString maintains report clarity
1. Add new abstractions
	- More genericity, easier to add tests cases

# Testing is coding

## Tests become too complex?

Like you learn to code, learn to test, you are just not used to it yet.
Like the code, use your design skills to keep the tests maintainable.
Keep the report simple and complete, it will tell you what goes wrong without having to dig in the test.

## Tests should remain simple because it is our source of truth?

Tests are not a source of truth: they can be bugged or incomplete, like any piece of code.
Like accountants ensure they work correctly with double entry bookkeeping, developer ensure they work correctly with code and tests:

https://youtu.be/HtxHH4vLCHs?si=_jEL-PRAxZjCJrDG

The tests do not verify the code, they only challenge it to some degree.
Identically, the code challenges the tests
Both of them are the source of truth of what is done: two different ways to say the same thing.

## Focus on the deliverables

The code is the description, the product is the deliverable.
The test is the description, the report is the deliverable.
The same way our goal is to deliver a good product, we should strive to deliver a good test report.
If the report is complete and easy to read, nothing else is required  to convince your manager the work is done.
Some practices (BDD) and tools (e.g. Cucumber) push for having test reports readable by business people:

https://cucumber.io/

The goal of the tests should be to deliver an informative report.
Design your tests to produce that kind of report, the same way you design your code to produce a correct deliverable.
Factoring, abstracting, creating libs/frameworks, etc. are all valid practices for testing.

# Conclusion

Have fun with your tests the same way you have fun with your code.
