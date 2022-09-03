library IEEE;
use IEEE.std_logic_1164.all;

entity ParityGenenerator is
    port(A,B,C: in bit; X: inout bit; P: out bit);
end ParityGenenerator;

entity xor2 is -- XOR 2 εισόδων
  port (X1,X2: in bit; O: out bit);
end xor2;

architecture structure of ParityGenenerator is

  component xor2
      port(X1,X2: in bit; O: out bit);
  end component;

begin
  u0: xor2 port map (A,B,X);
  u1: xor2 port map (X,C,P);
end structure;

architecture behave of xor2 is
begin
  O<= X1 xor X2;
end behave;
