library IEEE;
use IEEE.std_logic_1164.all;

-- Create full subtractor
entity Subtractor1_Struct is
    port (X,Y,Z: in bit ;
          D,bout: out bit);
end Subtractor1_Struct;
architecture algorithmic of Subtractor1_Struct is
begin
p0: process(X,Y,Z)
variable s: bit_vector (2 downto 0);
begin
s:= X&Y&Z;
 if s = "000" then D <= '0'; bout <= '0';
  elsif s = "001" then D <= '1'; bout <= '1';
  elsif s = "010" then D <= '1'; bout <= '1';
  elsif s = "011" then D <= '0'; bout <= '1';
  elsif s = "100" then D <= '1'; bout <= '0';
  elsif s = "101" then D <= '0'; bout <= '0';
  elsif s = "110" then D <= '0'; bout <= '0';
  elsif s = "111" then D <= '1'; bout <= '1';
  end if;
end process;
end algorithmic;

-- Create 4bit subtractor 
entity Subtractor4bit is port (
    A, B: in bit_vector (3 downto 0); -- Declare numbers to subtract
    diff: out bit_vector (3 downto 0);  --  Difference of two numbers
    borrow: inout bit_vector(4 downto 0));  -- Borrow of each subtractor
end Subtractor4bit;

-- Using Subtractor1_flow to create the 4 bit subtractor
architecture structure of Subtractor4bit is
component Subtractor1_Struct
  port (X,Y,Z: in bit ;
          D,bout: out bit);
end component;

begin
  g0: for index in 0 to 3 generate
u0: Subtractor1_Struct port map (
X=> A(index), Y=> B(index), D=> diff(index), Z=> borrow(index),
bout=> borrow (index+1));
   end generate;
end structure;
