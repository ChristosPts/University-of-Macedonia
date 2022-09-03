library IEEE;
use IEEE.std_logic_1164.all;

entity demux8x1 is
port (s0,s1,s2,D: in bit;  
      F0,F1,F2,F3,F4,F5,F6,F7: out bit);
end demux8x1;

architecture algorithmic of demux8x1 is
begin
    p0:process(s0,s1,s2,D)
    variable s: bit_vector (2 downto 0);
begin
     s:= s2&s1&s0;
    -----000-----
     if s = "000" then
      F0 <= D; F1 <= '0'; F2 <= '0'; F3 <= '0';
      F4 <= '0'; F5 <= '0'; F6 <= '0'; F7 <= '0';
    -----001-----
    elsif s = "001" then
      F0 <= '0'; F1 <= D; F2 <= '0'; F3 <= '0';
      F4 <= '0'; F5 <= '0'; F6 <= '0'; F7 <= '0';
    -----010-----
    elsif s = "010" then
      F0 <= '0'; F1 <= '0'; F2 <= D; F3 <= '0';
      F4 <= '0'; F5 <= '0'; F6 <= '0'; F7 <= '0';
    -----011-----
    elsif s = "011" then
      F0 <= '0'; F1 <= '0'; F2 <= '0'; F3 <= D;
      F4 <= '0'; F5 <= '0'; F6 <= '0'; F7 <= '0';
    -----100-----
    elsif  s = "100" then
      F0 <= '0'; F1 <= '0'; F2 <= '0'; F3 <= '0';
      F4 <= D; F5 <= '0'; F6 <= '0'; F7 <= '0';
    
    -----101-----
    elsif  s = "101" then
      F0 <= '0'; F1 <= '0'; F2 <= '0'; F3 <= '0';
      F4 <= '0'; F5 <= D; F6 <= '0'; F7 <= '0';
    -----110-----
    elsif s = "110" then
      F0 <= '0'; F1 <= '0'; F2 <= '0'; F3 <= '0';
      F4 <= '0'; F5 <= '0'; F6 <= D; F7 <= '0';
    -----111-----
    elsif s = "111" then
      F0 <= '0'; F1 <= '0'; F2 <= '0'; F3 <= '0';
      F4 <= '0'; F5 <= '0'; F6 <= '0'; F7 <= D;
    end if;
  end process;
end algorithmic;
