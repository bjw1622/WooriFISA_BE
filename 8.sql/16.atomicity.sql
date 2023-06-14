create  table account(
    account_id int primary key ,
    balance int
);

INSERT INTO account(account_id, balance) VALUES (1, 10000);
INSERT INTO account (account_id, balance) VALUES (2, 5000);

begin;
select balance from account where account_id = 1;

update account set balance = balance-2000 where account_id=1;

select * from account;
