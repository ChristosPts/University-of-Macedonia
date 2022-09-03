library IEEE;
use IEEE.std_logic_1164.all;
-- Creating a Positively Triggered D Flip - Flop
entity D_FlipFlop is
   port ( FFclk,FFreset,FFD: in bit; FFq: out bit);
end D_FlipFlop;

architecture Algorithmic of D_FlipFlop is
begin
    process(FFd,FFclk, FFreset)
        begin
-- Create a rollback feature
            if (FFreset = '1') then
                FFq <= '0';
    -- Value change event
            elsif (FFclk = '1')  and FFclk'event then
                FFq <= FFd;
            end if;
    end process;
end Algorithmic;

-- Creating a 4-bit counter
entity counter_4bit is
    Port ( clk,reset : in  bit;
           Q: out  bit_vector(3 downto 0));
end counter_4bit;

architecture Algorithmic of counter_4bit is
  component D_FlipFlop
       port ( FFclk,FFreset,FFD: in bit; FFq: out bit);
  end component;
 
signal q0, q1, q2,q3: bit;
begin
-- Creation of the 4 Flip-Flops and the corresponding bit assignment between them.
-- eg FF0 output FFq to be assigned to q0 and then q0 to be mapped as FF1's clk input
-- The output FFq of FF1 is assigned to q1 and then q1 is assigned as the clk input of FF2. ….
-- etc.
  FF0: D_FlipFlop
  port map(FFclk => clk, FFreset => reset, FFd => (not q0), FFq => q0);
  FF1: D_FlipFlop
  port map(FFclk =>(not q0), FFreset => reset, FFd => (not q1), FFq => q1);   
  FF2: D_FlipFlop
  port map(FFclk => (not q1), FFreset => reset, FFd => (not q2), FFq => q2);      
  FF3: D_FlipFlop
  port map(FFclk => (not q2),FFreset => reset, FFd => (not q3),FFq => q3);
 -- Output     
      Q <= q3 & q2 & q1 & q0;
end Algorithmic;
