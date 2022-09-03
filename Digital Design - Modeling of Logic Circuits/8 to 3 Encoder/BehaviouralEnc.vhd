library IEEE;
use IEEE.std_logic_1164.all;

entity encoder8x3 is
port (d0,d1,d2,d3,d4,d5,d6,d7: in bit;  
x,y,z: out bit);
end encoder8x3;

architecture algorithmic of encoder8x3 is
begin
p0: process (d7,d6,d5,d4,d3,d2,d1,d0)
variable s: bit_vector (7 downto 0);
 
begin
s:= d7&d6&d5&d4&d3&d2&d1&d0;
 if s = "00000001" then x <= '0'; y <= '0'; z <= '0';  
   elsif s = "00000010" then x <= '0'; y <= '0'; z <= '1';
   elsif s = "00000100" then x <= '0'; y <= '1'; z <= '0';  
   elsif s = "00001000" then x <= '0'; y <= '1'; z <= '1';  
   elsif s = "00010000" then x <= '1'; y <= '0'; z <= '0';
   elsif s = "00100000" then x <= '1'; y <= '0'; z <= '1';
   elsif s = "01000000" then x <= '1'; y <= '1'; z <= '0';
   elsif s = "10000000" then x <= '1'; y <= '1'; z <= '1';
 end if;

end process;
end algorithmic;

