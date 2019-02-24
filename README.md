Use case example of Clean architecture p192.

### Gather Contact Info for New Loan

Input: Name, Address, date of birth, D.L.#, SSN, etc.

Output: Same info for readback + credit score

Primary course: 

- Accept and validate name.
- Validate address, date of birth, D.L.#n SSN, etc.
- Get credit score
- If credit score is < 500 activate Denial
- Else create Customer and activate Loan Estimate  