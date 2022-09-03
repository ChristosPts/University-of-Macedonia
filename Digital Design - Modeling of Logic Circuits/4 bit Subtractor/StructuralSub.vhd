library IEEE;
use IEEE.std_logic_1164.all;
-- Create full subtractor
entity Subtractor1_Struct is
      port (X,Y,Z: in bit; bout, D: out bit;
      g1And,g2And,g3And: inout bit ); -- ‘g#And’ act as the and gates
end Subtractor1_Struct;

-- Creating entities
entity xor3 is -- XOR 3 εισοδων 
  port (X1,X2,X3: in bit; O: out bit);
end xor3;

entity inv is -- inverter
    port (X1: in bit; O: out bit);
end inv;

entity and2 is --AND gate with 2 inputs
    port (X1,X2: in bit; O: inout bit);
end and2;

entity or3 is -- OR gate with 3 inputs
    port (X1,X2,X3: in bit; O: out bit);
end or3;

architecture structure of Subtractor1_Struct is
  component inv
      port (X1: in bit; O: out bit);
  end component;

  component and2
      port(X1, X2 : in bit; O: inout bit);
  end component;

  component xor3
      port(X1, X2, X3 : in bit; O: out bit);
  end component;

  component or3
      port(X1,X2,X3: in bit; O:out bit);
  end component;    

signal s0:bit;
begin
  u0: inv port map(X, s0);   
  u1: xor3 port map(X,Y,Z,D);
  u2: and2 port map(s0,Z,g1And);
  u3: and2 port map(s0,Y,g2And);
  u4: and2 port map(Y,Z,g3And);
  u5: or3 port map(g1And,g2And,g3And,bout);   
end structure;
entity Subtractor4bit is port (
    A, B: in bit_vector (3 downto 0);
    diff: out bit_vector (3 downto 0);  
    borrow: inout bit_vector(4 downto 0));
end Subtractor4bit;

architecture structure of Subtractor4bit is
component Subtractor1_Struct
  port (X,Y,Z: in bit; bout, D: out bit;
  g1And,g2And,g3And: inout bit );
end component;

begin
  g0: for index in 0 to 3 generate
  u0: Subtractor1_Struct port map (
  X=> A(index), Y=> B(index), D=> diff(index), Z=> borrow(index),
  bout=> borrow (index+1));
end generate;
end structure;

--  Component functions
architecture behave of xor3 is
begin
  O<= X1 xor X2 xor X3;
end behave;

architecture behave of inv is
begin
  O<= not X1;
end behave;

architecture behave of and2 is
begin
  O<= X1 and X2;
end behave;

architecture behave of or3 is
begin
  O<= X1 or X2 or X3;
end behave;
