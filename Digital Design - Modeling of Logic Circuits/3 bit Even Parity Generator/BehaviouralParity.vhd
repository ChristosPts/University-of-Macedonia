library IEEE;
use IEEE.std_logic_1164.all;
entity ParityGenenerator is
    port(A,B,C: in bit; X: inout bit; P: out bit);
end ParityGenenerator;

architecture algorithmic of ParityGenenerator is
begin
-- Process for assigning value to X
p0: process (A,B)
variable s: bit_vector (1 downto 0);
begin
s:= A&B;
    if s ="00" then X <= '0';
    elsif  s ="01" then X <= '1';
    elsif  s ="10" then X <= '1';
    elsif  s ="11" then X <= '0';
 end if;
end process;
-- Process for assigning value to P
p1: process (X,C)
variable s: bit_vector (1 downto 0);
begin
s:= X&C;
    if s ="00" then P <= '0';
    elsif  s ="01" then P <= '1';
    elsif  s ="10" then P <= '1';
    elsif  s ="11" then P <= '0';
 end if;
end process;
end algorithmic;
